package com.frozenbloo.frostlibrary.string.colour;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringColour {
    private static final Pattern hexPattern = Pattern.compile("&(#[a-fA-F\\d]{6})");

    public static String HexColour(String str) {
        Matcher matcher = hexPattern.matcher(ChatColor.translateAlternateColorCodes('&' , str));
        StringBuffer buffer = new StringBuffer();

        while (matcher.find())
            matcher.appendReplacement(buffer , ChatColor.of(matcher.group(1)).toString());

        return matcher.appendTail(buffer).toString();
    }
}
