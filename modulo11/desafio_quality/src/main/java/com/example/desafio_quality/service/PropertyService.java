package com.example.desafio_quality.service;

import com.example.desafio_quality.dto.form.PropertyForm;
import com.example.desafio_quality.dto.response.PropertyDTO;
import com.example.desafio_quality.dto.response.PropertyRoomDTO;
import com.example.desafio_quality.dto.response.PropertyValueDTO;
import com.example.desafio_quality.entity.District;
import com.example.desafio_quality.entity.Property;
import com.example.desafio_quality.entity.Room;
import com.example.desafio_quality.repository.DistrictRepository;
import com.example.desafio_quality.repository.PropertyRepository;
import com.example.desafio_quality.util.mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private DistrictRepository districtRepository;

    public Property saveProperty(PropertyForm propertyForm) {
        return propertyRepository.saveProperty(PropertyMapper.toEntity(propertyForm));
    }

    public PropertyValueDTO propertyValue(Long id) {
        Property property = propertyRepository.find(id);
        District district = districtRepository.findByName(property.getDistrict());

        return new PropertyValueDTO(property.getName(), property.getPropertyValue(district.getValueM2()));
    }

    public PropertyRoomDTO biggerRoom(Long id) {
        Property property = propertyRepository.find(id);

        Room room = property.getRoomList().stream().max(Comparator.comparing(Room::getM2)).orElse(null);

        return new PropertyRoomDTO(property.getName(), room);
    }

    public PropertyDTO findOne(Long id) {
        return PropertyMapper.toDTO(propertyRepository.find(id));
    }

}
