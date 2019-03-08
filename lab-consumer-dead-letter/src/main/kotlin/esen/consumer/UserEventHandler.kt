package esen.consumer

import esen.event.UserCreatedEvent
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * UserEventHandler
 * @author Iamee
 * @create 2019-02-16 22:18
 */
@Component
@ProcessingGroup("user")
class UserEventHandler {

    companion object {
        val LOG = LoggerFactory.getLogger(UserEventHandler::class.java)
    }

    @EventHandler
    fun on(event: UserCreatedEvent) {
        LOG.info("创建用户死信消息: { username = ${event.username}}")
    }

}