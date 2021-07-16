package com.example.desafio_quality.entity;

import java.math.BigDecimal;
import java.util.List;

public class Property {
    private Long id;
    private String name;
    private String districtName;
    private List<Room> roomList;

    public Property(Long id, String name, String districtName, List<Room> roomList) {
        this.id = id;
        this.name = name;
        this.districtName = districtName;
        this.roomList = roomList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return districtName;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public Double getTotalM2() {
        return this.roomList.stream().mapToDouble(Room::getM2).sum();
    }
}
