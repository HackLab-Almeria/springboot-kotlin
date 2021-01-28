package net.hacklab.springbootkotlin

import net.hacklab.springbootkotlin.pokemon.PokemonRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.server.ResponseStatusException

data class Pokemon(var id: Int,var nombre:String, var tipo:String)

@Controller
@RequestMapping("/web")
class WebController(private val pokemonRepository: PokemonRepository) {

    @GetMapping("/pokemon")
    fun blog(model: Model):String{
        model["title"]="Pokemon"
        val listaPokemons = listOf<Pokemon>(Pokemon(1,"Pikachu","Rayo"),
            Pokemon(2,"Squirtle", "Agua")
        )
        model["pokemons"]=pokemonRepository.findAll()
        return "pokelista"
    }

    @GetMapping("/pokemon/{id}")
    fun pokemon(@PathVariable id:Int, model: Model):String{
        model["title"]="Detalle Pokemon"
        model["pokemon"]=pokemonRepository.findByIdOrNull(id)?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        return "pokemon"
    }

}