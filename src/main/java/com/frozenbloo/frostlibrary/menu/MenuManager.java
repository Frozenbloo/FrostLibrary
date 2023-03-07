package com.frozenbloo.frostlibrary.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MenuManager {

    private static MenuManager instance;
    private final Map<UUID, FrostMenu> openMenus;

    public MenuManager() {
        this.openMenus = new HashMap<>();
    }

    public static MenuManager getInstance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    public void registerMenu(UUID toRegister, FrostMenu menu) {
        openMenus.put(toRegister, menu);
    }

    public void unregisterMenu(UUID toUnRegister) {
        openMenus.remove(toUnRegister);
    }

    public FrostMenu matchMenu(UUID user) {
        return openMenus.get(user);
    }
}
