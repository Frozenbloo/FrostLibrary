package com.frozenbloo.frostlibrary.player;

import com.frozenbloo.frostlibrary.string.colour.StringColour;
import org.bukkit.entity.Player;

public class PlayerUtils {

    /**
     * Sends a message to a player with the specified string.
     *
     * @param player The player to send the message to.
     * @param str The string to send as the message.
     */
    public static void MessagePlayer(Player player, String str) {
        // Convert any hex color codes in the string to their corresponding ChatColor values
        String convertedStr = StringColour.HexColour(str);

        // Send the converted string as a message to the player
        player.sendMessage(convertedStr);
    }
}
