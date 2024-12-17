package br.com.beatriz.vo.response

import br.com.beatriz.vo.request.Message

data class ChatGptResponse (
    val choices: ArrayList<Choice>
)