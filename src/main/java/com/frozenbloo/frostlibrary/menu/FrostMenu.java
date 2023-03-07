package com.frozenbloo.frostlibrary.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static com.frozenbloo.frostlibrary.string.colour.StringColour.HexColour;

public class FrostMenu {

    private Inventory inventory;
    private Map<Integer, MenuButton> buttonMap;
    private Consumer<Player> inventoryClosed;
    private Consumer<Player> inventoryOpened;
    private BukkitRunnable menuUpdater;

    public FrostMenu(String title, int rows) {
        if (rows > 6 || rows < 1 || title.length() > 32) {
            throw new IllegalArgumentException("Invalid arguments passed to FrostMenu constructor.");
        }
        this.inventory = Bukkit.createInventory(null, (rows * 9), HexColour(title));
        this.buttonMap = new HashMap<>();
    }

    public void registerButton(MenuButton button, int slot) {
        buttonMap.put(slot, button);
    }

    public void setInventoryClosed(Consumer<Player> inventoryClosed) {
        this.inventoryClosed = inventoryClosed;
    }

    public void setInventoryOpened(Consumer<Player> inventoryOpened) {
        this.inventoryOpened = inventoryOpened;
    }

    public void handleClose(Player player) {
        if (inventoryClosed != null) {
            inventoryClosed.accept(player);
        }
    }

    public void handleOpen(Player player) {
        if (inventoryOpened != null) {
            inventoryOpened.accept(player);
        }
    }

    public void handleClick(InventoryClickEvent event) {
        event.setCancelled(true);
        ItemStack clicked = event.getCurrentItem();

        if (clicked == null){
            return;
        }

        if (buttonMap.containsKey(event.getRawSlot())) {
            Consumer<Player> consumer = buttonMap.get(event.getRawSlot()).getWhenClicked();

            if (consumer != null){
                consumer.accept((Player) event.getWhoClicked());
            }
        }
    }

    public void open(Player player) {
        MenuManager manager = MenuManager.getInstance();
        buttonMap.forEach((slot, button) -> {
            inventory.setItem(slot, button.getItemStack());
        });

        player.openInventory(inventory);
        manager.registerMenu(player.getUniqueId(), this);
        handleOpen(player);
    }

    public void onUpdate() {}
}
