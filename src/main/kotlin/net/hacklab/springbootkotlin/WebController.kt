package net.hacklab.springbootkotlin

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HtmlController {

    @RequestMapping("/blog")
    fun blog(model: Model):String{
        model["title"]="Blog"
        return "blog"
    }
}