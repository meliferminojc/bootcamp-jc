package br.com.meli.linktracker.utils;

public class generateIds {
    private static long id = 1l;

    public static long generate() {
        return id++;
    }
}
