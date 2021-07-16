package com.example.desafio_quality.controller;

import com.example.desafio_quality.dto.form.PropertyForm;
import com.example.desafio_quality.repository.PropertyRepository;
import com.example.desafio_quality.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getProperties(@PathVariable Long id) {
        return ResponseEntity.ok(propertyService.findOne(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProperty(@RequestBody PropertyForm propertyForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.saveProperty(propertyForm));
    }

}
