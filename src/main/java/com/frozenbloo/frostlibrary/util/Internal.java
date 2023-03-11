package com.frozenbloo.frostlibrary.util;

import com.frozenbloo.frostlibrary.FrostLibrary;

import static com.frozenbloo.frostlibrary.string.colour.StringColour.HexColour;

public class Internal {

    public static String GetIceArt() {
        return HexColour("                                                  \n" +
                "                                                  \n" +
                "                                                  \n" +
                "                                                  \n" +
                "                                                  \n" +
                "                    ████████                      \n" +
                "                ████░░░░░░░░████                  \n" +
                "            ████░░░░░░░░░░░░░░░░████              \n" +
                "        ████░░░░░░░░░░░░░░░░░░░░░░░░████          \n" +
                "        ██░░████░░░░░░░░░░░░░░░░████  ██          \n" +
                "        ██░░░░░░████░░░░░░░░████░░  ░░██          \n" +
                "        ██░░░░░░░░░░████████░░░░  ░░░░██          \n" +
                "        ██░░░░░░  ░░░░░░██░░░░░░░░░░░░██          \n" +
                "        ██░░░░  ░░░░░░░░██░░░░░░░░░░░░██          \n" +
                "        ██░░  ░░░░░░░░░░██░░░░░░  ░░░░██          \n" +
                "        ██░░░░░░░░░░░░  ██░░░░  ░░░░░░██          \n" +
                "        ██░░░░░░░░░░  ░░██░░  ░░░░░░░░██          \n" +
                "        ████░░░░░░  ░░░░██░░░░░░░░░░████          \n" +
                "            ████░░░░░░░░██░░░░░░████              \n" +
                "                ████░░░░██░░████                  \n" +
                "                    ████████                      \n" +
                "                                                  \n" +
                "                                                  \n" +
                "                                                  \n" +
                "                                                  \n");
    }

    public static void EnableMetrics(){
        Metrics metrics = new Metrics(FrostLibrary.getInstance(), 17917);
    }
}
