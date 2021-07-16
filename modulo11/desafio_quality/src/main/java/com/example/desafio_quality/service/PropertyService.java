package com.example.desafio_quality.service;

import com.example.desafio_quality.dto.form.PropertyForm;
import com.example.desafio_quality.dto.response.PropertyDTO;
import com.example.desafio_quality.entity.District;
import com.example.desafio_quality.entity.Property;
import com.example.desafio_quality.repository.DistrictRepository;
import com.example.desafio_quality.repository.PropertyRepository;
import com.example.desafio_quality.util.mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private DistrictRepository districtRepository;

    public Property saveProperty(PropertyForm propertyForm) {
        return propertyRepository.saveProperty(PropertyMapper.toEntity(propertyForm));
    }

    public PropertyDTO findOne(Long id) {
        return PropertyMapper.toDTO(propertyRepository.find(id));
    }

}
