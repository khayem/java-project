package com.kata.fbq;

import java.util.HashMap;
import java.util.Map;

public class FooBarQix
{
    // Max numbers to print
    public static final int MAX = 100;

    // FooBarQix patterns
    public static final String FOO = "Foo";
    public static final String BAR = "Bar";
    public static final String QIX = "Qix";
    public static final String EMPTY = "";

    // Patterns sorted by digit (0-9)
    private static final String[] INTEGER_PATTERNS = { EMPTY, EMPTY, EMPTY, FOO, EMPTY, BAR, EMPTY, QIX, EMPTY, EMPTY };
    // Patterns sorted by char ('0'-'9')
    private static final Map<Character, String> CHAR_PATTERNS;
    static {
        CHAR_PATTERNS = new HashMap<Character, String>();
        CHAR_PATTERNS.put('0', EMPTY);
        CHAR_PATTERNS.put('1', EMPTY);
        CHAR_PATTERNS.put('2', EMPTY);
        CHAR_PATTERNS.put('3', FOO);
        CHAR_PATTERNS.put('4', EMPTY);
        CHAR_PATTERNS.put('5', BAR);
        CHAR_PATTERNS.put('6', EMPTY);
        CHAR_PATTERNS.put('7', QIX);
        CHAR_PATTERNS.put('8', EMPTY);
        CHAR_PATTERNS.put('9', EMPTY);
    }

    public static void main( String[] args )
    {
        String[] result = new FooBarQix().execute(MAX);
        for (String s : result) {
            System.out.println(s);
        }
    }

    protected String[] execute(int max) {
        String[] result = new String[max];

        for (int i = 1; i <= max; i++) {
            String si = String.valueOf(i);
            String line = transformModulo(i, 3) + transformModulo(i, 5) + replaceNumbers(si);
            result[i - 1] = EMPTY.equals(line) ? si : line;
        }

        return result;
    }

    /*
     * Checks if a number (i) is divisible by another (modulo) and returns the appropriate pattern.
     */
    private String transformModulo(int i, int modulo) {
        return i % modulo == 0 ? INTEGER_PATTERNS[modulo] : EMPTY;
    }

    /*
     * Replace characters by the appropriate pattern.
     */
    private String replaceNumbers(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            res.append(CHAR_PATTERNS.get(c));
        }
        return res.toString();
    }
}
