package com.example.desafio_quality.dto.response;

import java.math.BigDecimal;

public class DistrictDTO {
    private Long id;
    private String name;
    private BigDecimal valueM2;

    public DistrictDTO(Long id, String name, BigDecimal valueM2) {
        this.id = id;
        this.name = name;
        this.valueM2 = valueM2;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValueM2() {
        return valueM2;
    }
}
