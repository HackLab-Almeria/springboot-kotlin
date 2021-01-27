package net.hacklab.springbootkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

data class Greeting(var response:String)

@RestController
class HelloBoot {

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value="name", defaultValue = "World")name:String)= Greeting("Hello $name")
}