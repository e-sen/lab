package esen.producer

import esen.command.CreateUserCommand
import esen.event.UserCreatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.commandhandling.model.AggregateLifecycle
import org.axonframework.commandhandling.model.AggregateMember
import org.axonframework.eventhandling.EventHandler
import org.axonframework.spring.stereotype.Aggregate

/**
 * UserAggregate
 * @author Iamee
 * @create 2019-02-16 21:06
 */
@Aggregate
class UserAggregate {

    @AggregateIdentifier
    lateinit var uid: String

    @AggregateMember
    lateinit var username: String

    constructor()

    @CommandHandler
    constructor(command: CreateUserCommand) {
        AggregateLifecycle.apply(UserCreatedEvent(uid = command.uid, username = command.username, time = System.currentTimeMillis()))
    }

    @EventHandler
    fun on(event:UserCreatedEvent){

    }

}