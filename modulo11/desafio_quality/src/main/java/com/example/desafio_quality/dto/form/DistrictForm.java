package com.example.desafio_quality.dto.form;

import java.math.BigDecimal;

public class DistrictForm {
    private String district_name;
    private BigDecimal value_district_m2;

    public DistrictForm(String district_name, BigDecimal value_district_m2) {
        this.district_name = district_name;
        this.value_district_m2 = value_district_m2;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }
}
