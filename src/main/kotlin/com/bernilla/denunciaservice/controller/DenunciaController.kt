package com.bernilla.denunciaservice.controller

import com.bernilla.denunciaservice.entity.Denuncia
import com.bernilla.denunciaservice.service.DenunciaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/denuncias")
@CrossOrigin(origins = ["*"])
class DenunciaController(private val service: DenunciaService) {

    @PostMapping
    fun registrar(@RequestBody denuncia: Denuncia): ResponseEntity<Denuncia> {
        val nueva = service.registrar(denuncia)
        return ResponseEntity(nueva, HttpStatus.CREATED)
    }

    @GetMapping
    fun listarPaginado(
        @RequestParam(defaultValue = "0") offset: Int,
        @RequestParam(defaultValue = "5") limit: Int
    ): ResponseEntity<List<Denuncia>> {
        return ResponseEntity.ok(service.listarPaginado(offset, limit))
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Int): ResponseEntity<Denuncia> {
        val denuncia = service.obtenerPorId(id)
        return if (denuncia != null) ResponseEntity.ok(denuncia) else ResponseEntity.notFound().build()
    }

    @GetMapping("/ciudadano/{dni}")
    fun obtenerPorDni(@PathVariable dni: String): ResponseEntity<List<Denuncia>> {
        return ResponseEntity.ok(service.obtenerPorDni(dni))
    }

    @PutMapping("/{id}")
    fun atenderDenuncia(@PathVariable id: Int): ResponseEntity<Denuncia> {
        val atendida = service.atenderDenuncia(id)
        return if (atendida != null) ResponseEntity.ok(atendida) else ResponseEntity.notFound().build()
    }
}