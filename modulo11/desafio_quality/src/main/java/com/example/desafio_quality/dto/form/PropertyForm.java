package com.example.desafio_quality.dto.form;

import java.util.List;

public class PropertyForm {
    private String prop_name;
    private String prop_district;
    private List<RoomForm> prop_rooms;

    public PropertyForm(String prop_name, String prop_district, List<RoomForm> prop_rooms) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.prop_rooms = prop_rooms;
    }

    public String getProp_name() {
        return prop_name;
    }

    public String getProp_district() {
        return prop_district;
    }

    public List<RoomForm> getProp_rooms() {
        return prop_rooms;
    }
}
