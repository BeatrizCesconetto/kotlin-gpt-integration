package br.com.beatriz.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.web.client.RestTemplate
import java.util.logging.Logger

@Configuration
class OpenAiConfig {

    private val logger = Logger.getLogger(OpenAiConfig::class.java.name)

    @Value("\${openai.api.key}") // Pega o valor da API no application.yml
    var openApiKey: String? = null

    @Bean
    fun template(): RestTemplate {
        val restTemplate = RestTemplate()
        restTemplate.interceptors.add(
            ClientHttpRequestInterceptor {
                request: HttpRequest, body:  ByteArray, execution: ClientHttpRequestExecution ->
                request.headers.add("Authorization", "Bearer $openApiKey")
                execution.execute(request, body)
            })
        return restTemplate
    }
}