package br.com.beatriz.controller

import br.com.beatriz.service.ChatGptService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bot")
class ChatGptController {

    @Autowired
    private lateinit var service: ChatGptService

    @GetMapping("/chat")
    fun chat(@RequestParam("prompt") prompt: String) : Any {
        return service.chat(prompt)
    }
}