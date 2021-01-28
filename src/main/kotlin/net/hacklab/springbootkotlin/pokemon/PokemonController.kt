package net.hacklab.springbootkotlin.pokemon

import com.querydsl.core.BooleanBuilder
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/pokemon/")
class PokemonController(
    val pokemonRepository: PokemonRepository,
    val attackRepository: AttackRepository
) {


    @GetMapping("/")
    fun list(
        @RequestParam type: String?,
        @RequestParam attack: String?,
        page: Pageable
    ): Page<Pokemon> {

        val p = QPokemon.pokemon
        val query = BooleanBuilder()

        if (type != null)
            query.and(p.type.equalsIgnoreCase(type))

        if (attack != null)
            query.and(p.attacks.any().name.equalsIgnoreCase(attack))


        return pokemonRepository.findAll(query, page)
    }


    @PostMapping("/")
    fun create(@RequestBody pokemon: Pokemon): Pokemon {

        pokemonRepository.save(pokemon)

        return pokemon
    }


    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): Pokemon {
        return pokemonRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }


    @PutMapping("/{id}")
    fun update(@RequestBody pokemon: Pokemon, @PathVariable id: Int): Pokemon {
        val old = get(id)

        old.name = pokemon.name
        old.type = pokemon.type

        pokemonRepository.save(old)

        return old
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        val pokemon = get(id)

        pokemonRepository.delete(pokemon)
    }


    @PostMapping("/{id}/attack/")
    fun addAttack(@RequestBody attack: Attack, @PathVariable id: Int): Pokemon {
        val pokemon = get(id)

        pokemon.attacks.add(attack)

        attackRepository.save(attack)
        pokemonRepository.save(pokemon)

        return pokemon
    }


}
