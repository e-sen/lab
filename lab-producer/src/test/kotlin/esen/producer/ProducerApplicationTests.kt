package esen.producer

import esen.command.CreateUserCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class ProducerApplicationTests {

    @Autowired
    lateinit var commandGateway: CommandGateway

    private val username = "username"

    @Test
    fun createUser_normal() {
        val uid = "1"
        val result = commandGateway.sendAndWait<Any>(CreateUserCommand(uid = uid, username = username))
        Assert.assertEquals(result, uid)
    }

    @Test
    fun createUser_dead_letter(){
        val uid = "2"
        val result = commandGateway.sendAndWait<Any>(CreateUserCommand(uid = uid, username = username))
        Assert.assertEquals(result, uid)
    }
}

