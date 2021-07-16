package com.example.desafio_quality.dto.form;

public class RoomForm {
    private String name;
    private Double width;
    private Double length;

    public RoomForm(String name, Double width, Double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public Double getWidth() {
        return width;
    }

    public Double getLength() {
        return length;
    }
}
