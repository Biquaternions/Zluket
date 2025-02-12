package net.serlith.zluket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.shell.command.annotation.CommandScan

@CommandScan
@EnableScheduling
@SpringBootApplication
class ZluketApplication

fun main(args: Array<String>) {
    runApplication<ZluketApplication>(*args)
}
