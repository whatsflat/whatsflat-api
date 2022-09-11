package de.heuerleon.whatsflat.api.repository

import de.heuerleon.whatsflat.api.model.GroupMember
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GroupMemberRepository : JpaRepository<GroupMember, Long>