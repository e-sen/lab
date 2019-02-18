package esen

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAdminServer
class LabAdminApplication

fun main(args: Array<String>) {
    runApplication<LabAdminApplication>(*args)
}
