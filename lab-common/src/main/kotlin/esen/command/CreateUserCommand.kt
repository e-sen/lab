package esen.command

import org.axonframework.commandhandling.TargetAggregateIdentifier

/**
 * CreateUserCommand
 * @author Iamee
 * @create 2019-02-16 21:02
 */
data class CreateUserCommand(@TargetAggregateIdentifier val uid: String, val username: String)