package esen.producer

import org.axonframework.eventsourcing.eventstore.EventStorageEngine
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * AxonConfig
 * @author Iamee
 * @create 2019-02-16 21:42
 */
@Configuration
class AxonConfig {

    @Bean
    fun storageEngine(): EventStorageEngine {
        return InMemoryEventStorageEngine()
    }

}