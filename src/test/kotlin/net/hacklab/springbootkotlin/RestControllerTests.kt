package net.hacklab.springbootkotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestControllerTests(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `assert Rest Controller to Hello World`() {
        println(">> Rest Controller with HelloWorld")
        val entity = restTemplate.getForEntity<String>("/greeting")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("Hello World")
    }

}