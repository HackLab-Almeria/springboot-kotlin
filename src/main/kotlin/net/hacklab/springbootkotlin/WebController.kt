package net.hacklab.springbootkotlin

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

data class Pokemon(var id: Int,var nombre:String, var tipo:String)

@Controller
class WebController {

    @GetMapping("/blog")
    fun blog(model: Model):String{
        model["title"]="Pokemon"
        val listaPokemons = listOf<Pokemon>(Pokemon(1,"Pikachu","Rayo"),
            Pokemon(2,"Squirtle", "Agua")
        )
        model["pokemons"]=listaPokemons
        return "pokelista"
    }

    @GetMapping("/pokemon/{id}")
    fun pokemon(@PathVariable id:Int, model: Model):String{
        model["title"]="Detalle Pokemon"
        model["pokemon"]=Pokemon(1,"Pikachu","Rayo")
        return "pokemon"
    }

}