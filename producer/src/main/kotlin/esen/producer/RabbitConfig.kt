package esen.producer

import org.axonframework.boot.AMQPProperties
import org.springframework.amqp.core.Exchange
import org.springframework.amqp.core.ExchangeBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * RabbitConfig
 * @author Iamee
 * @create 2019-02-16 21:48
 */
@Configuration
class RabbitConfig {

    @Autowired
    lateinit var properties: AMQPProperties

    @Bean
    fun exchange(): Exchange {
        val args = HashMap<String, String>()
        args["x-dead-letter-exchange"] = properties.exchange
        args["x-dead-letter-routing-key"] = "#"
        return ExchangeBuilder.topicExchange(properties.exchange)
                .withArguments(args.toMap())
                .durable(properties.isDurableMessages)
                .build()
    }

}