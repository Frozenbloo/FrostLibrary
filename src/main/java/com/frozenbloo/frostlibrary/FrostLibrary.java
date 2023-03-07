package com.frozenbloo.frostlibrary;

import com.frozenbloo.frostlibrary.player.string.colour.StringColour;
import com.frozenbloo.frostlibrary.util.Internal;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class FrostLibrary extends JavaPlugin {

    // Private static field to hold a reference to the plugin
    private static JavaPlugin plugin;

    // Private static field to hold reference to main;
    @Getter
    private static FrostLibrary instance;

    /**
     * Returns the plugin instance.
     *
     * @return The plugin instance.
     */
    public static JavaPlugin getPlugin() {
        return plugin;
    }

    /**
     * Sets the plugin instance.
     *
     * @param plugin The plugin instance to set.
     */
    public static void setPlugin(final JavaPlugin plugin) {
        FrostLibrary.plugin = plugin;
    }

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(StringColour.HexColour(Internal.GetIceArt()));
    }
}
