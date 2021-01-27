package net.hacklab.springbootkotlin

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootkotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringbootkotlinApplication>(*args){
		setBannerMode(Banner.Mode.OFF)
	}
}
