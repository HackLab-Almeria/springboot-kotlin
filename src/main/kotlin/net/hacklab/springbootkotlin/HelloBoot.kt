package net.hacklab.springbootkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController



@RestController
class HelloBoot {

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value="name", defaultValue = "World")name:String):String{

        return if (name=="Cris")
            "Hello $name; instálate Telegram"
        else
            "Hello $name"
    }
}