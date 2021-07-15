package com.example.desafio_quality.util;

public class GenerateID {
    private static long idProperty = 1L;
    private static long idDistrict = 1L;
    private static long idRoom = 1L;

    public static long toProperty() {
        return idProperty++;
    }

    public static long toDistrict() {
        return idDistrict++;
    }

    public static long toRoom() {
        return idRoom++;
    }
}
