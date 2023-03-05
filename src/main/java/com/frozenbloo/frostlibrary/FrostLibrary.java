package com.frozenbloo.frostlibrary;

import org.bukkit.plugin.java.JavaPlugin;

public final class FrostLibrary {

    // Private static field to hold a reference to the plugin
    private static JavaPlugin plugin;

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
}
