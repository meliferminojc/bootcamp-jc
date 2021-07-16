package com.example.desafio_quality.dto.response;

import java.math.BigDecimal;

public class PropertyValueDTO {
    private String name;
    private BigDecimal propertyValue;

    public PropertyValueDTO(String name, BigDecimal propertyValue) {
        this.name = name;
        this.propertyValue = propertyValue;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPropertyValue() {
        return propertyValue;
    }
}
