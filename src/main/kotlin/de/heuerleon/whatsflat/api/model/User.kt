package de.heuerleon.whatsflat.api.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,
    var username : String,
    var password : String,
)