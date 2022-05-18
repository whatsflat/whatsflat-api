package de.heuerleon.whatsflat.api.repository

import de.heuerleon.whatsflat.api.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>