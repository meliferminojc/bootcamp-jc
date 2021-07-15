package com.example.desafio_quality.entity;

public class Room {
    private Long id;
    private String name;
    private Double width;
    private Double length;

    public Room(Long id, String name, Double width, Double length) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public Long getId() {
        return id;
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
