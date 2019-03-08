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

    private var index = 0

    @EventHandler
    fun on(event: UserCreatedEvent) {
        LOG.info("创建用户事件: { uid = ${event.uid} , username = ${event.username} }")
        if (event.uid.hashCode() % 2 == 0) {
            throw RuntimeException("确定异常")
        }
        LOG.info("创建用户正常消息: { username = ${event.username}}")
    }

}