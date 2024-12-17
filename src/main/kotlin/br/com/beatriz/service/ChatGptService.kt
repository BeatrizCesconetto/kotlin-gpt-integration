package br.com.beatriz.service

import br.com.beatriz.vo.request.ChatGptRequest
import br.com.beatriz.vo.request.Message
import br.com.beatriz.vo.response.ChatGptResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.logging.Logger

@Service
class ChatGptService {
    private val logger = Logger.getLogger(ChatGptService::class.java.name)

    @Value("\${openai.model}") // Pega o valor do model da API no application.yml
    private lateinit var model: String

    @Value("\${openai.api.url}") // Pega o url do model da API no application.yml
    private lateinit var apiUrl: String

    @Autowired
    private lateinit var template: RestTemplate

    fun chat(prompt: String): String {

        logger.info("Starting Prompt")

        val messages = arrayListOf(Message("user", prompt))
        val request = ChatGptRequest(model, messages)

        val jsonString = ObjectMapper().writeValueAsString(request)

        logger.info(jsonString)
        logger.info("Processing Prompt")

        val response = template.postForObject(apiUrl, request, ChatGptResponse::class.java)

        return response!!.choices[0].message.content //Pega somente a resposta da API
    }
}