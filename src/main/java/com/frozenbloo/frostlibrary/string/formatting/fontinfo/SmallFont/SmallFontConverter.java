package com.frozenbloo.frostlibrary.string.formatting.fontinfo.SmallFont;

import java.util.HashMap;
import java.util.Map;

public class SmallFontConverter {

    private static final Map<Character, Character> smallFontDict = new HashMap<>();

    static {
        smallFontDict.put('A' , '\u1D00');
        smallFontDict.put('B' , '\u0299');
        smallFontDict.put('C' , '\u1D04');
        smallFontDict.put('D' , '\u1D05');
        smallFontDict.put('E' , '\u1D07');
        smallFontDict.put('F' , '\uA730');
        smallFontDict.put('G' , '\u0262');
        smallFontDict.put('H' , '\u029C');
        smallFontDict.put('I' , '\u026A');
        smallFontDict.put('J' , '\u1D0A');
        smallFontDict.put('K' , '\u1D0B');
        smallFontDict.put('L' , '\u029F');
        smallFontDict.put('M' , '\u1D0D');
        smallFontDict.put('N' , '\u0274');
        smallFontDict.put('O' , '\u1D0F');
        smallFontDict.put('P' , '\u1D18');
        smallFontDict.put('Q' , '\u0071');
        smallFontDict.put('R' , '\u0280');
        smallFontDict.put('S' , '\uA731');
        smallFontDict.put('T' , '\u1D1B');
        smallFontDict.put('U' , '\u1D1C');
        smallFontDict.put('V' , '\u1D20');
        smallFontDict.put('W' , '\u1D21');
        smallFontDict.put('X' , '\u0078');
        smallFontDict.put('Y' , '\u028F');
        smallFontDict.put('Z' , '\u1D22');
        smallFontDict.put('a' , '\u1D00');
        smallFontDict.put('b' , '\u0299');
        smallFontDict.put('c' , '\u1D04');
        smallFontDict.put('d' , '\u1D05');
        smallFontDict.put('e' , '\u1D07');
        smallFontDict.put('f' , '\uA730');
        smallFontDict.put('g' , '\u0262');
        smallFontDict.put('h' , '\u029C');
        smallFontDict.put('i' , '\u026A');
        smallFontDict.put('j' , '\u1D0A');
        smallFontDict.put('k' , '\u1D0B');
        smallFontDict.put('l' , '\u029F');
        smallFontDict.put('m' , '\u1D0D');
        smallFontDict.put('n' , '\u0274');
        smallFontDict.put('o' , '\u1D0F');
        smallFontDict.put('p' , '\u1D18');
        smallFontDict.put('q' , '\u0071');
        smallFontDict.put('r' , '\u0280');
        smallFontDict.put('s' , '\uA731');
        smallFontDict.put('t' , '\u1D1B');
        smallFontDict.put('u' , '\u1D1C');
        smallFontDict.put('v' , '\u1D20');
        smallFontDict.put('w' , '\u1D21');
        smallFontDict.put('x' , '\u0078');
        smallFontDict.put('y' , '\u028F');
        smallFontDict.put('z', '\u1D22');
        smallFontDict.put('{', '\u007B');
        smallFontDict.put('|', '\u007C');
        smallFontDict.put('}', '\u007D');
        smallFontDict.put('~', '\u02DC');
    }

    public static String ConvertToSmallFont(String input) {
        input = input.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (smallFontDict.containsKey(c)) {
                result.append(smallFontDict.get(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
