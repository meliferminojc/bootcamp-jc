package com.example.desafio_quality.service;

import com.example.desafio_quality.dto.form.DistrictForm;
import com.example.desafio_quality.dto.response.DistrictDTO;
import com.example.desafio_quality.dto.response.ListDistrictDTO;
import com.example.desafio_quality.entity.District;
import com.example.desafio_quality.repository.DistrictRepository;
import com.example.desafio_quality.util.mapper.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public ListDistrictDTO listDistricts() {
        return new ListDistrictDTO(districtRepository.getAll());
    }

    public DistrictDTO saveDistrict(DistrictForm districtForm){
        District district = districtRepository.add(DistrictMapper.toEntity(districtForm));
        return DistrictMapper.toDTO(district);
    }
}
