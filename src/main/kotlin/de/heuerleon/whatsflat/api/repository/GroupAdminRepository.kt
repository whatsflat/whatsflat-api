package de.heuerleon.whatsflat.api.repository

import de.heuerleon.whatsflat.api.model.GroupAdmin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GroupAdminRepository : JpaRepository<GroupAdmin, Long>