package net.hacklab.springbootkotlin.pokemon

import javax.persistence.*


@Entity
@Table(name = "pokemons")
class Pokemon(
    @Id var id: Int = 0,
    var name: String = "",
    var type: String = "",

    @Column(columnDefinition = "integer default 1")
    var generation: Int = 0,

    @OneToMany()
    var attacks: MutableList<Attack> = ArrayList()
)
