package com.bernilla.denunciaservice.service

import com.bernilla.denunciaservice.entity.Denuncia
import com.bernilla.denunciaservice.repository.DenunciaRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class DenunciaService(private val repository: DenunciaRepository) {

    fun registrar(denuncia: Denuncia): Denuncia {
        denuncia.estado = 1 // Estado inicial 1 (Pendiente)
        return repository.save(denuncia)
    }

    fun listarPaginado(offset: Int, limit: Int): List<Denuncia> {
        val pageNumber = offset / limit
        return repository.findAll(PageRequest.of(pageNumber, limit)).content
    }

    fun obtenerPorId(id: Int): Denuncia? {
        return repository.findById(id).orElse(null)
    }

    fun obtenerPorDni(dni: String): List<Denuncia> {
        return repository.findByDni(dni)
    }

    fun atenderDenuncia(id: Int): Denuncia? {
        val denuncia = repository.findById(id).orElse(null) ?: return null
        denuncia.estado = 0 // Cambia a 0 (Atendida)
        return repository.save(denuncia)
    }
}