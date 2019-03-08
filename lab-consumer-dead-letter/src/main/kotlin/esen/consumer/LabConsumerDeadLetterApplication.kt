package esen.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LabConsumerDeadLetterApplication

fun main(args: Array<String>) {
    runApplication<LabConsumerDeadLetterApplication>(*args)
}

