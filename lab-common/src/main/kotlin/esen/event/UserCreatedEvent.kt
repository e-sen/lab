package esen.event

import org.axonframework.commandhandling.TargetAggregateIdentifier

/**
 * UserCreatedEvent
 * @author Iamee
 * @create 2019-02-16 21:05
 */
data class UserCreatedEvent(@TargetAggregateIdentifier val uid: String, val username: String, val time: Long)