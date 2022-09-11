package de.heuerleon.whatsflat.api.model

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "group_owners")
data class GroupAdmin (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @Column(name = "user_id") val userId: Long,
    @Column(name = "group_id") val groupId: Long
    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as GroupAdmin

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , userId = $userId , groupId = $groupId )"
    }
}