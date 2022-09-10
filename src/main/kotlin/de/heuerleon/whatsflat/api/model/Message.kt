package de.heuerleon.whatsflat.api.model

import org.hibernate.Hibernate
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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Message

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , sender = $sender , recipient = $recipient , " +
                "recipientType = $recipientType , timestamp = $timestamp , body = $body )"
    }
}