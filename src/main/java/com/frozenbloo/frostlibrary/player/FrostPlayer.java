package com.frozenbloo.frostlibrary.player;

import com.frozenbloo.frostlibrary.string.colour.StringColour;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;

public class FrostPlayer {

    /**
     * Enum to represent the type of client connected to the server.
     */
    public enum Client {
        Java, // Represents a Java Edition client
        Bedrock // Represents a Bedrock Edition client
    }

    @Getter
    private final Client client;

    @Getter
    private final Player player;

    /**
     * Constructor to create a new instance of FrostPlayer.
     *
     * @param player The player associated with this FrostPlayer instance.
     */
    public FrostPlayer(Player player) {
        this.player = player;
        // Determine the client type for the player
        this.client = getClient(player);
    }

    /**
     * Method to determine the client type for a player.
     *
     * @param player The player to determine the client type for.
     * @return The type of client the player is using (Java or Bedrock).
     */
    private Client getClient(Player player) {
        if (FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId())) {
            return Client.Bedrock;
        }
        return Client.Java;
    }

    /**
     * Method to send a message to the player with color formatting.
     *
     * @param str The message to send to the player.
     */
    public void messagePlayer(String str) {
        // Convert any hex color codes in the string to their corresponding ChatColor values
        String convertedStr = StringColour.HexColour(str);

        // Send the converted string as a message to the player
        player.sendMessage(convertedStr);
    }
}
