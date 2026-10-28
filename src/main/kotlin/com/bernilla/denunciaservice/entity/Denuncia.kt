package com.bernilla.denunciaservice.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "denuncias")
data class Denuncia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false, length = 8)
    var dni: String = "",

    @Column(nullable = false)
    var fecha: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false, length = 30)
    var tipo: String = "",

    @Column(nullable = false, length = 200)
    var direccion: String = "",

    @Column(nullable = false, length = 255)
    var descripcion: String = "",

    @Column(nullable = false)
    var estado: Int = 1 // 1 = Pendiente
)