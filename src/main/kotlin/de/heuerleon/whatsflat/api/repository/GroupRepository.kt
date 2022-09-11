package de.heuerleon.whatsflat.api.repository

import de.heuerleon.whatsflat.api.model.Group
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GroupRepository : JpaRepository<Group, Long>