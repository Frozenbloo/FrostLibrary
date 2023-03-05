package com.frozenbloo.frostlibrary.player;

import com.frozenbloo.frostlibrary.string.colour.StringColour;
import org.bukkit.entity.Player;

public class PlayerUtils {

    public static void MessagePlayer(Player player, String str) {
        player.sendMessage(StringColour.HexColour(str));
    }
}
