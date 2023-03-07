package com.frozenbloo.frostlibrary.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class MenuListener implements Listener {
    
    @EventHandler
    public void InventoryClick(InventoryClickEvent e) {
        FrostMenu matchedMenu = MenuManager.getInstance().matchMenu(e.getWhoClicked().getUniqueId());
        
        if (matchedMenu != null) {
            matchedMenu.handleClick(e);
        }
    }

    @EventHandler
    public void InventoryClose(InventoryCloseEvent e) {
        FrostMenu matchedMenu = MenuManager.getInstance().matchMenu(e.getPlayer().getUniqueId());

        if (matchedMenu != null) {
            matchedMenu.handleClose((Player) e.getPlayer());
        }

        MenuManager.getInstance().unregisterMenu(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void PlayerQuit(PlayerQuitEvent e) {
        FrostMenu matchedMenu = MenuManager.getInstance().matchMenu(e.getPlayer().getUniqueId());

        if (matchedMenu != null) {
            matchedMenu.handleClose(e.getPlayer());
        }

        MenuManager.getInstance().unregisterMenu(e.getPlayer().getUniqueId());
    }
}
