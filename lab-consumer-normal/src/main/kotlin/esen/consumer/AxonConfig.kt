package esen.consumer

import org.axonframework.config.EventHandlingConfiguration
import org.axonframework.eventhandling.ListenerInvocationErrorHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * AxonConfig
 * @author Iamee
 * @create 2019-02-16 22:14
 */
@Configuration
class AxonConfig {

    @Bean
    fun eventHandlingConfiguration(): EventHandlingConfiguration {
        val configuration = EventHandlingConfiguration()
        configuration.configureListenerInvocationErrorHandler("user") {
            ListenerInvocationErrorHandler { exception, _, _ -> throw exception }
        }
        return configuration
    }

}