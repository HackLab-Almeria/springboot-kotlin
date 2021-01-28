package net.hacklab.springbootkotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.*
import org.springframework.web.client.RestTemplate
import java.util.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestControllerTests(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `assert Rest Controller to Hello World`() {
        println(">> Rest Controller with HelloWorld -> 401")
        val entity = restTemplate.getForEntity<String>("/greeting")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.UNAUTHORIZED)

    }

    @Test
    fun `assert Rest Controller authenticated to Hello World`(){
        println(">> Rest Controller Authenticated With Hello World")

        val entity=restTemplate.exchange("/greeting",
            HttpMethod.GET,HttpEntity<String>(createHttpHeaders("admin","admin"))
            , String.javaClass )
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).isNotNull()
    }

    fun createHttpHeaders(user:String, pass:String):HttpHeaders {
        var headers=HttpHeaders()
        headers.add("Authorization",
            "Basic " + Base64.getEncoder().encodeToString("$user:$pass".toByteArray()))

        return headers
    }


}