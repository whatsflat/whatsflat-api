package de.heuerleon.whatsflat.api.model

import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "messages")
data class Message(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val sender: Long,
    val recipient: Long,
    @Column(name = "recipient_type")
    val recipientType: Int,
    val timestamp: Timestamp,
    var body: String
)