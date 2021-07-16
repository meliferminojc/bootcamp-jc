package com.example.desafio_quality.dto.form;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class DistrictForm {
    @NotNull(message = "Não pode ser null")
    @NotEmpty(message = "Não pode ser vazio")
    @Size(max = 45, message = "Não pode ter mais que 45 caracteres")
    private String district_name;

    @NotNull(message = "Não pode ser null")
    @DecimalMax(value = "999999999.999", message = "Não pode ter mais que 13 digitos")
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
