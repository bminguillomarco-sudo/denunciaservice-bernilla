package com.bernilla.denunciaservice.repository

import com.bernilla.denunciaservice.entity.Denuncia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DenunciaRepository : JpaRepository<Denuncia, Int> {
    fun findByDni(dni: String): List<Denuncia>
}