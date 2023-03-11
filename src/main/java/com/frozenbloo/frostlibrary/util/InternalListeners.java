package com.frozenbloo.frostlibrary.util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class InternalListeners implements Listener {

    @EventHandler
    public void onCommandSend(PlayerCommandSendEvent e) {
        e.getCommands().removeIf(command -> command.contains(":"));
    }
}
