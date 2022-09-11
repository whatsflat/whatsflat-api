package de.heuerleon.whatsflat.api.controller

import de.heuerleon.whatsflat.api.model.Group
import de.heuerleon.whatsflat.api.repository.GroupAdminRepository
import de.heuerleon.whatsflat.api.repository.GroupMemberRepository
import de.heuerleon.whatsflat.api.repository.GroupRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/whatsflat")
class GroupController(
    private val groupRepository: GroupRepository,
    private val groupAdminRepository: GroupAdminRepository,
    private val groupMemberRepository: GroupMemberRepository
) {

    @GetMapping("/groups")
    fun getAllGroups(): List<Group> =
        groupRepository.findAll()

    @PostMapping("/groups")
    fun createNewGroup(@RequestBody group: Group): Group =
        groupRepository.save(group)

    @GetMapping("/groups/{id}")
    fun getGroupById(@PathVariable(value = "id") groupId: Long): ResponseEntity<Group> {
        return groupRepository.findById(groupId).map { group ->
            ResponseEntity.ok(group)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/groups/{id}")
    fun deleteGroupById(@PathVariable(value = "id") groupId: Long): ResponseEntity<Void> {
        return groupRepository.findById(groupId).map { group ->
            groupRepository.delete(group)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}