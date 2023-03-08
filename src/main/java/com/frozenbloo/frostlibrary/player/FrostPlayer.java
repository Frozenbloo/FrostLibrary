package com.frozenbloo.frostlibrary.player;

import com.frozenbloo.frostlibrary.string.colour.StringColour;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;

public class FrostPlayer {

    public enum Client {
        Java, Bedrock
    }

    @Getter
    private final Client client;

    @Getter
    private final Player player;

    public FrostPlayer(Player player) {
        this.player = player;
        this.client = getClient(player);
    }

    private Client getClient(Player player) {
        if (FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId())) return Client.Bedrock;
        return Client.Java;
    }

    public void MessagePlayer(String str) {
        // Convert any hex color codes in the string to their corresponding ChatColor values
        String convertedStr = StringColour.HexColour(str);

        // Send the converted string as a message to the player
        player.sendMessage(convertedStr);
    }
}
