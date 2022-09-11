package de.heuerleon.whatsflat.api.controller

import de.heuerleon.whatsflat.api.model.LoginData
import de.heuerleon.whatsflat.api.model.User
import de.heuerleon.whatsflat.api.repository.UserRepository
import org.mindrot.jbcrypt.BCrypt
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/whatsflat")
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/users")
    fun getAllUsers(): List<User> =
        userRepository.findAll()

    @PostMapping("/users")
    fun createNewUser(@RequestBody user: User): ResponseEntity<User> {
        val passwordHash = BCrypt.hashpw(user.password, BCrypt.gensalt())
        user.password = passwordHash
        return ResponseEntity.ok().body(userRepository.save(user))
    }

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable(value = "id") userId: Long): ResponseEntity<User> {
        return userRepository.findById(userId).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/users/{id}")
    fun updateUserById(@PathVariable(value = "id") userId: Long, @RequestBody user: User): ResponseEntity<User> {
        return userRepository.findById(userId).map { oldUser ->
            val passwordHash = BCrypt.hashpw(user.password, BCrypt.gensalt())
            val updatedUser = oldUser.copy(username = user.username, password = passwordHash)
            ResponseEntity.ok().body(userRepository.save(updatedUser))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/users/{id}")
    fun deleteUserById(@PathVariable(value = "id") userId: Long): ResponseEntity<Void> {
        return userRepository.findById(userId).map { user ->
            userRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/users/try_login")
    fun tryLogin(@RequestBody loginData: LoginData) : ResponseEntity<Boolean> {
        return userRepository.findByUsername(loginData.username).map { user ->
            val check = BCrypt.checkpw(loginData.password, user.password)
            ResponseEntity.ok().body(check)
        }.orElse(ResponseEntity.ok().body(false))
    }

}