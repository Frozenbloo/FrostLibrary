package com.frozenbloo.frostlibrary.player.frostplayer;

import com.frozenbloo.frostlibrary.player.FrostPlayer;

import java.util.HashMap;
import java.util.UUID;

public class FrostPlayerManager {

    private HashMap<UUID, FrostPlayer> frostPlayers = new HashMap<>();

    /**
     * Retrieves the FrostPlayer associated with the given UUID.
     *
     * @param uuid The UUID of the player to retrieve.
     * @return The FrostPlayer instance associated with the given UUID.
     */
    public FrostPlayer getFrostPlayer(UUID uuid) {
        return frostPlayers.get(uuid);
    }

    /**
     * Adds a FrostPlayer instance to the manager with the given UUID.
     *
     * @param uuid   The UUID to associate with the FrostPlayer instance.
     * @param player The FrostPlayer instance to add to the manager.
     */
    public void addFrostPlayer(UUID uuid, FrostPlayer player) {
        frostPlayers.put(uuid, player);
    }

    /**
     * Removes the FrostPlayer instance associated with the given UUID from the manager.
     *
     * @param uuid The UUID of the FrostPlayer instance to remove.
     */
    public void removeFrostPlayer(UUID uuid) {
        frostPlayers.remove(uuid);
    }
}
