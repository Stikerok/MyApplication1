package com.example.myapplication1

import java.util.*

data class Message(
    val initId: Int,
    var id: Int = initId,
    val senderId: Int = 0,
    val text: String,
    val date: Date = Date()
) {
    operator fun plus(message: Message): Message {
        return if (this.id == message.initId) {
            this.copy(text = this.text + "\n" + message.text)
        } else {
            this.copy(
                text = this.text + "\n" + "Id: " + message.initId + ", Time: " + message.date + ", Text=" + message.text,
                id = message.initId
            )
        }
    }

    override fun toString(): String {
        return "Id: $initId, Time: $date, Text=$text\n"
    }

}