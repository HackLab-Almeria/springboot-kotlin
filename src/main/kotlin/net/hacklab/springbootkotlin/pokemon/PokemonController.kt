package net.hacklab.springbootkotlin.pokemon

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/pokemon/")
class PokemonController {


    @GetMapping("/")
    fun list(@RequestParam type: String?): List<Pokemon> {

        if (type == null)
            return POKEMONS


        return POKEMONS.filter { it.type == type }
    }


    @PostMapping("/")
    fun create(@RequestBody pokemon: Pokemon): Pokemon {
        POKEMONS.add(pokemon)
        POKEMONS.sortBy { it.id }

        return pokemon
    }


    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): Pokemon {
        return POKEMONS.firstOrNull { it.id == id } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }


    @PutMapping("/{id}")
    fun update(@RequestBody pokemon: Pokemon, @PathVariable id: Int): Pokemon {
        val old = get(id)

        old.name = pokemon.name
        old.type = pokemon.type

        return old
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        val pokemon = get(id)

        POKEMONS.remove(pokemon)
    }


    companion object {
        val POKEMONS = arrayListOf(
            Pokemon(1, "Bulbasaur", "plant"),
            Pokemon(4, "Charmander", "fire"),
            Pokemon(7, "Squirtle", "water")
        )
    }

}
