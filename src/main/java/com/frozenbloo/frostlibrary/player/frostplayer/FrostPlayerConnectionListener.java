package com.frozenbloo.frostlibrary.player.frostplayer;

import com.frozenbloo.frostlibrary.FrostLibrary;
import com.frozenbloo.frostlibrary.player.FrostPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class FrostPlayerConnectionListener implements Listener {

    /**
     * Handles the PlayerLoginEvent and adds a FrostPlayer instance to the FrostPlayerManager.
     *
     * @param e The PlayerLoginEvent to handle.
     */
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e) {
        FrostPlayer frostPlayer = new FrostPlayer(e.getPlayer());
        FrostLibrary.getInstance().getFrostPlayerManager().addFrostPlayer(e.getPlayer().getUniqueId(), frostPlayer);

        // Logs the client type of the player who just logged in.
        Bukkit.getLogger().info("Client of player " + e.getPlayer().getName() + " is " + frostPlayer.getClient());
    }

    /**
     * Handles the PlayerQuitEvent and removes the corresponding FrostPlayer instance from the FrostPlayerManager.
     *
     * @param e The PlayerQuitEvent to handle.
     */
    @EventHandler
    public void onPlayerLogout(PlayerQuitEvent e) {
        FrostLibrary.getInstance().getFrostPlayerManager().removeFrostPlayer(e.getPlayer().getUniqueId());
    }
}
