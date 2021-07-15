package com.example.desafio_quality.dto.response;

import com.example.desafio_quality.entity.District;

import java.util.List;

public class ListDistrictDTO {
    private List<District> districtList;

    public ListDistrictDTO(List<District> districtList) {
        this.districtList = districtList;
    }

    public List<District> getDistrictList() {
        return districtList;
    }
}
