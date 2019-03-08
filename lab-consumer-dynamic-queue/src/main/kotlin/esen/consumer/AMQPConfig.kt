package esen.consumer

import org.axonframework.amqp.eventhandling.AMQPMessageConverter
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerEndpoint
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

/**
 * AMQPConfig
 * @author Iamee
 * @create 2019-02-16 22:15
 */
@Configuration
class AMQPConfig {

    companion object {
        val queue = "esen.consumer.normal.${UUID.randomUUID()}"
    }

    @Bean
    fun axonQueueMessageSource(messageConverter: AMQPMessageConverter): SpringAMQPMessageSource {
        return object : SpringAMQPMessageSource(messageConverter) {}
    }

    @Bean
    fun simpleMessageListenerContainer(listener: SpringAMQPMessageSource, factory: SimpleRabbitListenerContainerFactory): SimpleMessageListenerContainer {
        return factory.createListenerContainer(SimpleRabbitListenerEndpoint().apply {
            setQueueNames(queue)
            messageListener = MessageListenerAdapter(ChannelAwareMessageListener { message, channel ->
                listener.onMessage(message, channel)
            })
        })
    }

}