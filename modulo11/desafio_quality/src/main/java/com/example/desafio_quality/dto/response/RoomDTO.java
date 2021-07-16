package com.example.desafio_quality.dto.response;

public class RoomDTO {
    private String name;
    private Double roomM2;

    public RoomDTO(String name, Double roomM2) {
        this.name = name;
        this.roomM2 = roomM2;
    }

    public String getName() {
        return name;
    }

    public Double getRoomM2() {
        return roomM2;
    }
}
