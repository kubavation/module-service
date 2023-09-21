package com.durys.jakub.moduleservice.events

import com.durys.jakub.moduleservice.events.model.Event
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
internal class Events(@Value("\${queue.events}") private val queue: String, val rabbitTemplate: RabbitTemplate) {

    fun emit(event: Event) {
        rabbitTemplate.convertAndSend(queue, event)
    }
}