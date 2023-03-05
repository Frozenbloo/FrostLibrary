package com.frozenbloo.frostlibrary;

import org.bukkit.plugin.java.JavaPlugin;

public final class FrostLibrary {

    private static JavaPlugin plugin;

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static void setPlugin(final JavaPlugin plugin) {
        FrostLibrary.plugin = plugin;
    }
}