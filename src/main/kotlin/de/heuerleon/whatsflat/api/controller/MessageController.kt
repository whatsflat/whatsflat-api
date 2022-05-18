package de.heuerleon.whatsflat.api.controller

import de.heuerleon.whatsflat.api.model.Message
import de.heuerleon.whatsflat.api.repository.MessageRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MessageController(private val messageRepository: MessageRepository) {

    @GetMapping("/messages")
    fun getAllMessages(): List<Message> =
        messageRepository.findAll()

    @PostMapping("/messages")
    fun createNewMessage(@RequestBody message: Message): Message =
        messageRepository.save(message)

    @GetMapping("/messages/{id}")
    fun getMessageById(@PathVariable(value = "id") messageId: Long): ResponseEntity<Message> {
        return messageRepository.findById(messageId).map { message ->
            ResponseEntity.ok(message)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/messages/{id}")
    fun updateMessageById(@PathVariable(value = "id") messageId: Long, @RequestBody message: Message): ResponseEntity<Message> {
        return messageRepository.findById(messageId).map { oldMessage ->
            val updatedMessage = oldMessage.copy(body = message.body)
            ResponseEntity.ok().body(messageRepository.save(updatedMessage))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/messages/{id}")
    fun deleteMessageById(@PathVariable(value = "id") messageId: Long): ResponseEntity<Void> {
        return messageRepository.findById(messageId).map { message ->
            messageRepository.delete(message)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
    
}