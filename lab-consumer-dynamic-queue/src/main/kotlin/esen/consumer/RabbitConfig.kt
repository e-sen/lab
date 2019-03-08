package esen.consumer

import org.axonframework.boot.AMQPProperties
import org.springframework.amqp.core.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * RabbitConfig
 * @author Iamee
 * @create 2019-02-16 22:22
 */
@Configuration
class RabbitConfig {

    @Autowired
    lateinit var properties: AMQPProperties

    @Bean
    fun exchange(): Exchange {
        return ExchangeBuilder.topicExchange(properties.exchange)
                .durable(properties.isDurableMessages)
                .build()
    }

    @Bean
    fun queue(): Queue {
        return QueueBuilder.durable(AMQPConfig.queue).autoDelete().build()
    }

    @Bean
    fun binding(): Binding {
        return Binding(AMQPConfig.queue, Binding.DestinationType.QUEUE, properties.exchange, "#", null)
    }

}