package com.frozenbloo.frostlibrary;

import com.frozenbloo.frostlibrary.menu.MenuListener;
import com.frozenbloo.frostlibrary.player.frostplayer.FrostPlayerConnectionListener;
import com.frozenbloo.frostlibrary.player.frostplayer.FrostPlayerManager;
import com.frozenbloo.frostlibrary.string.colour.StringColour;
import com.frozenbloo.frostlibrary.util.Internal;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.geysermc.floodgate.api.FloodgateApi;

import static org.bukkit.Bukkit.getPluginManager;

public final class FrostLibrary extends JavaPlugin {

    // Private static field to hold a reference to the plugin
    private static JavaPlugin plugin;

    // Private static field to hold reference to main;
    @Getter
    private static FrostLibrary instance;

    @Getter
    private FrostPlayerManager frostPlayerManager;

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
        Bukkit.getLogger().info("Loading Floodgate API");
        try{
            FloodgateApi.getInstance();
        } catch(Exception ex){
            Bukkit.getLogger().severe(ex.getMessage());
            Bukkit.getLogger().severe("Floodgate API FAILURE!");
        }
        Bukkit.getLogger().info("Floodgate API Loaded Successfully");
        frostPlayerManager = new FrostPlayerManager();
        Bukkit.getConsoleSender().sendMessage(StringColour.HexColour(Internal.GetIceArt()));
        getPluginManager().registerEvents(new FrostPlayerConnectionListener(), this);
        getPluginManager().registerEvents(new MenuListener(), this);
    }
}
