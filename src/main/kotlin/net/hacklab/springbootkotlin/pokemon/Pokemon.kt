package net.hacklab.springbootkotlin.pokemon

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity
@Table(name = "pokemons")
class Pokemon(
    @Id var id: Int = 0,
    var name: String = "",
    var type: String = "",


    @OneToMany()
    var attacks: MutableList<Attack> = ArrayList()
)
