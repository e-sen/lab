package esen.consumer

import com.rabbitmq.client.Channel
import org.axonframework.amqp.eventhandling.AMQPMessageConverter
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * AMQPConfig
 * @author Iamee
 * @create 2019-02-16 22:15
 */
@Configuration
class AMQPConfig {

    companion object {
        const val queue = "esen.consumer.dead-letter"
    }

    @Bean
    fun axonQueueMessageSource(messageConverter: AMQPMessageConverter): SpringAMQPMessageSource {
        return object : SpringAMQPMessageSource(messageConverter) {
            @RabbitListener(queues = [queue])
            override fun onMessage(message: Message?, channel: Channel?) {
                super.onMessage(message, channel)
            }
        }
    }

}