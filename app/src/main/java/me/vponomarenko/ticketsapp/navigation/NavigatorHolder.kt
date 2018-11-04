package me.vponomarenko.ticketsapp.navigation

import me.vponomarenko.ticketsapp.navigation.commands.AsRoot
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
        if (nav == null) {
            saveCommand(command)
            return
        }
        if (command is ForwardForResult) {
            nav.consumeCommand(Forward(command.screen))
        } else {
            nav.consumeCommand(command)
        }
    }

    private fun saveCommand(command: Command) {
        if (command is AsRoot) commandsBuffer.clear()
        commandsBuffer.add(command)
    }
}