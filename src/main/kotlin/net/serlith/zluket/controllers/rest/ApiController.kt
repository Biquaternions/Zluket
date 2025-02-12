package net.serlith.zluket.controllers.rest

import jakarta.servlet.http.HttpServletRequest
import net.serlith.zluket.databases.PasteRepository
import net.serlith.zluket.databases.types.PasteModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/api")
class ApiController

@Autowired
constructor(
    private val pasteRepository: PasteRepository,
) {

    @Value("\${zluket.api.content.max_length}")
    private var contentMaxLength: Int = 0

    @PostMapping("/documents")
    fun postCreateDocument(@RequestBody content: String?): ResponseEntity<Any> {
        if (content == null || content.isBlank()) return ResponseEntity.noContent().build()

        var truncated = false
        var content = content
        if (content.length > this.contentMaxLength) {
            content = content.substring(0, contentMaxLength)
            truncated = true
        }

        val paste = this.pasteRepository.save(PasteModel(content))
        return ResponseEntity.ok(mapOf(
            "uuid" to paste.uuid,
            "truncated" to truncated,
        ))
    }

    @GetMapping("/documents/{uuid}")
    fun getDocument(@PathVariable uuid: UUID): ResponseEntity<Any> {
        val paste = this.pasteRepository.findById(uuid).getOrNull() ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(mapOf(
            "uuid" to paste.uuid,
            "content" to paste.content,
            "created" to paste.created,
        ))
    }

}