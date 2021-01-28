package net.hacklab.springbootkotlin.pokemon

import org.springframework.data.jpa.repository.JpaRepository

interface AttackRepository : JpaRepository<Attack, Int> {
}
