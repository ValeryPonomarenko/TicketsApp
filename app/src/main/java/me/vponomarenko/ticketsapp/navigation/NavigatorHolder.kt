package me.vponomarenko.ticketsapp.navigation

import me.vponomarenko.ticketsapp.navigation.commands.Command
import me.vponomarenko.ticketsapp.navigation.commands.Forward
import me.vponomarenko.ticketsapp.navigation.commands.ForwardForResult
import java.util.concurrent.LinkedBlockingQueue

class NavigatorHolder {

    private var navigator: Navigator? = null

    private val commandsBuffer = LinkedBlockingQueue<Command>()

    fun setNavigator(navigator: Navigator) {
        this.navigator = navigator
        while (!commandsBuffer.isEmpty()) {
            navigator.consumeCommand(commandsBuffer.poll())
        }
    }

    fun releaseNavigator() {
        navigator = null
    }

    fun consumeCommand(command: Command) {
        val nav = navigator
        if (nav != null) {
            if (command is ForwardForResult) {
                nav.consumeCommand(Forward(command.screenName, command.data))
            } else {
                nav.consumeCommand(command)
            }
        } else {
            saveCommand(command)
        }
    }

    private fun saveCommand(command: Command) {
        commandsBuffer.add(command)
    }
}