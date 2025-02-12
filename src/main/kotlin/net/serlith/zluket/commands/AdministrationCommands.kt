package net.serlith.zluket.commands

import org.springframework.boot.SpringApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.shell.command.annotation.Command
import kotlin.system.exitProcess

@Suppress("unused")
@Command(group = "Administration Commands")
class AdministrationCommands : ApplicationContextAware {

    private lateinit var applicationContext: ApplicationContext

    @Command(command = ["stop"], description = "Stops the server")
    fun adminStop() {
        SpringApplication.exit(this.applicationContext, { -> 0})
        exitProcess(0)
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
    }

}