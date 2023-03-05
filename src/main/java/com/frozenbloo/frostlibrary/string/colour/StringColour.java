package com.frozenbloo.frostlibrary.string.colour;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringColour {
    // Regular expression pattern for matching hex color codes in the format of '&#RRGGBB'
    private static final Pattern hexPattern = Pattern.compile("&(#[a-fA-F\\d]{6})");

    /**
     * Replaces all instances of hex color codes in a string with their corresponding ChatColor values.
     *
     * @param str The string to convert.
     * @return The converted string with all hex color codes replaced with ChatColor values.
     */
    public static String HexColour(String str) {
        // Translate any '&' color codes into their ChatColor equivalents, then create a Matcher object to find hex color codes
        Matcher matcher = hexPattern.matcher(ChatColor.translateAlternateColorCodes('&', str));

        // StringBuffer to hold the converted string as it's being built
        StringBuffer buffer = new StringBuffer();

        // Loop through each hex color code match found by the Matcher and replace it with its ChatColor equivalent
        while (matcher.find())
            matcher.appendReplacement(buffer, ChatColor.of(matcher.group(1)).toString());

        // Add any remaining text to the end of the converted string
        return matcher.appendTail(buffer).toString();
    }
}
