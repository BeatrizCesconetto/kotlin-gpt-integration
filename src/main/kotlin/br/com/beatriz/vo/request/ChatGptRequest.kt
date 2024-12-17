package br.com.beatriz.vo.request

data class ChatGptRequest (
    val model: String,
    val messages: ArrayList<Message>
)