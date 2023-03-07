package com.frozenbloo.frostlibrary.menu;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class MenuButton {

    @Getter
    private ItemStack itemStack;
    private Consumer<Player> whenClicked;

    public MenuButton(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public Consumer<Player> getWhenClicked() {
        return whenClicked;
    }

    public MenuButton setWhenClicked(Consumer<Player> whenClicked) {
        this.whenClicked = whenClicked;
        return this;
    }
}
