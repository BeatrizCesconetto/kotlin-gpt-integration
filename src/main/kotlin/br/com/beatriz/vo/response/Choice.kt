package br.com.beatriz.vo.response

import br.com.beatriz.vo.request.Message

data class Choice(
    var index: Int = 0,
    var message: Message
)
