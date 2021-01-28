package net.hacklab.springbootkotlin.pokemon

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "attacks")
class Attack(
    @Id
    @GeneratedValue
    var id: Int = 0,


    var name: String = "",
    var pp: Int = 0
)
