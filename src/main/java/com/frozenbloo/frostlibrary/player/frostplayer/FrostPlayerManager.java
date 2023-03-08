package com.frozenbloo.frostlibrary.player.frostplayer;

import com.frozenbloo.frostlibrary.player.FrostPlayer;

import java.util.HashMap;
import java.util.UUID;

public class FrostPlayerManager {

    private HashMap<UUID, FrostPlayer> frostPlayers = new HashMap<>();

    public FrostPlayer getFrostPlayer(UUID uuid) {
        return frostPlayers.get(uuid);
    }

    public void addFrostPlayer(UUID uuid, FrostPlayer player) {
        frostPlayers.put(uuid, player);
    }

    public void removeFrostPlayer(UUID uuid) {
        frostPlayers.remove(uuid);
    }
}
