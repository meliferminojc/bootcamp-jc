package com.example.desafio_quality.controller;

import com.example.desafio_quality.dto.form.DistrictForm;
import com.example.desafio_quality.dto.response.ListDistrictDTO;
import com.example.desafio_quality.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping("/list")
    public ResponseEntity<?> listDistricts(ListDistrictDTO listDistrictDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(districtService.listDistricts());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDistrict(@RequestBody DistrictForm districtDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(districtService.saveDistrict(districtDTO));
    }
}
