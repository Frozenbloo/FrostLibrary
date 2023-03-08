package com.frozenbloo.frostlibrary.player.frostplayer;

import com.frozenbloo.frostlibrary.FrostLibrary;
import com.frozenbloo.frostlibrary.player.FrostPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class FrostPlayerConnectionListener implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e) {
        FrostLibrary.getInstance().getFrostPlayerManager().addFrostPlayer(e.getPlayer().getUniqueId() , new FrostPlayer(e.getPlayer()));
        Bukkit.getLogger().info("Client of player " + e.getPlayer().getName() + " is " + FrostLibrary.getInstance().getFrostPlayerManager().getFrostPlayer(e.getPlayer().getUniqueId()).getClient());
    }

    @EventHandler
    public void onPlayerLogout(PlayerQuitEvent e) {
        FrostLibrary.getInstance().getFrostPlayerManager().removeFrostPlayer(e.getPlayer().getUniqueId());
    }
}
