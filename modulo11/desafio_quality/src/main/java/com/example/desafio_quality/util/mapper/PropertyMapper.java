package com.example.desafio_quality.util.mapper;

import com.example.desafio_quality.dto.form.PropertyForm;
import com.example.desafio_quality.dto.response.PropertyDTO;
import com.example.desafio_quality.dto.response.RoomDTO;
import com.example.desafio_quality.entity.Property;
import com.example.desafio_quality.util.GenerateID;

import java.util.ArrayList;
import java.util.List;

public class PropertyMapper {

    public static Property toEntity(PropertyForm propertyForm) {
        return new Property(
                GenerateID.toProperty(),
                propertyForm.getProp_name(),
                propertyForm.getProp_district(),
                RoomMapper.toEntity(propertyForm.getProp_rooms())
        );
    }

    public static PropertyDTO toDTO(Property property) {
        List<RoomDTO> roomDTOList = new ArrayList<>();

        property.getRoomList().forEach(room -> roomDTOList.add(new RoomDTO(room.getName(), room.getM2())));


        return new PropertyDTO(
                property.getName(),
                property.getName(),
                roomDTOList,
                property.getTotalM2()
        );
    }
}
