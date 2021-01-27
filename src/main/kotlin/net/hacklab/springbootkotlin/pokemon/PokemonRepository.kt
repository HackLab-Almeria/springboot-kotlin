package net.hacklab.springbootkotlin.pokemon

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository : JpaRepository<Pokemon, Int> {


    fun findAllByType(type: String, page: Pageable): Page<Pokemon>


}
