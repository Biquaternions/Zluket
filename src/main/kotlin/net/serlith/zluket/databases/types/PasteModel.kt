package net.serlith.zluket.databases.types

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "pastes")
class PasteModel (

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    var content: String = "",

) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var uuid: UUID? = null

    @Column(name = "created_at", nullable = false)
    var created: LocalDateTime = LocalDateTime.now()

}
