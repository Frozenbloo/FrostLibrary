package com.frozenbloo.frostlibrary.command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static com.frozenbloo.frostlibrary.player.string.colour.StringColour.HexColour;

/**
 * A custom command class that extends the BukkitCommand class and provides some additional functionality.
 */
public abstract class FrostCommand extends BukkitCommand {

    /**
     * Constructs a new FrostCommand object with the specified command, aliases, description, and permission.
     *
     * @param command       the main command name
     * @param aliases       an array of alternative command names
     * @param description   a short description of the command's purpose
     * @param permission    the permission required to use the command
     * @param permissionMsg the message displayed when the player doesn't have permission
     */
    public FrostCommand(String command, String[] aliases, String description, String permission, String permissionMsg) {
        super(command);

        // Set the command's aliases, description, permission, and permissionMsg
        this.setAliases(Arrays.asList(aliases));
        this.setDescription(HexColour(description));
        this.setPermission(permission);
        this.setPermissionMessage(HexColour(permissionMsg));

        // Register the command with the server's CommandMap using reflection
        try {
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            CommandMap map = (CommandMap) field.get(Bukkit.getServer());
            map.register(command, this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executes the command with the given sender and arguments.
     *
     * @param sender       the sender of the command
     * @param commandLabel the command name or alias used to trigger the command
     * @param args         an array of arguments passed with the command
     * @return always returns false
     */
    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        execute(sender, args);
        return false;
    }

    /**
     * Executes the command with the given sender and arguments.
     *
     * @param sender the sender of the command
     * @param args   an array of arguments passed with the command
     */
    public abstract void execute(CommandSender sender, String[] args);

    /**
     * Provides tab-completion for the command with the given sender, alias, and arguments.
     *
     * @param sender the sender of the command
     * @param alias  the command name or alias used to trigger the command
     * @param args   an array of arguments passed with the command
     * @return a list of possible completions for the given arguments
     * @throws IllegalArgumentException if any argument is null
     */
    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        return onTabComplete(args);
    }

    /**
     * Provides tab-completion for the command with the given arguments.
     *
     * @param args an array of arguments passed with the command
     * @return a list of possible completions for the given arguments
     */
    public abstract List<String> onTabComplete(String[] args);
}
