package com.example.desafio_quality.dto.response;

import java.util.List;

public class PropertyDTO {
    private String name;
    private String districtName;
    private List<RoomDTO> roomDTOList;
    private Double totalM2;

    public PropertyDTO(String name, String districtName, List<RoomDTO> roomDTOList, Double totalM2) {
        this.name = name;
        this.districtName = districtName;
        this.roomDTOList = roomDTOList;
        this.totalM2 = totalM2;
    }

    public String getName() {
        return name;
    }

    public String getDistrictName() {
        return districtName;
    }

    public List<RoomDTO> getRoomDTOList() {
        return roomDTOList;
    }

    public Double getTotalM2() {
        return totalM2;
    }
}
