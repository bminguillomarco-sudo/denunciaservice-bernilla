package com.bernilla.denunciaservice.controller

import com.bernilla.denunciaservice.repository.DenunciaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/denuncias")
class DenunciaWebController {

    @Autowired
    private lateinit var denunciaRepository: DenunciaRepository

    @GetMapping("/tabla")
    fun verTabla(model: Model): String {
        model.addAttribute("denuncias", denunciaRepository.findAll())
        return "denuncias-tabla"
    }
}