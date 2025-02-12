package net.serlith.zluket.databases

import net.serlith.zluket.databases.types.PasteModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.UUID

@Repository
interface PasteRepository: CrudRepository<PasteModel, UUID> {
    fun findAllByCreatedBefore(time: LocalDateTime): List<PasteModel>
}