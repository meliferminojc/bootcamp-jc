package com.example.desafio_quality.entity;

import java.math.BigDecimal;
import java.util.List;

public class Property {
    private Long id;
    private String name;
    private District district;
    private List<Room> roomList;

    public Property(Long id, String name, District district, List<Room> roomList) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.roomList = roomList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public District getDistrict() {
        return district;
    }

    public List<Room> getRoomList() {
        return roomList;
    }
}
