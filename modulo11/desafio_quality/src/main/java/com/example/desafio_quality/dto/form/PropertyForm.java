package com.example.desafio_quality.dto.form;

import javax.validation.constraints.*;
import java.util.List;

public class PropertyForm {
    @NotNull(message = "Não pode ser null")
    @NotEmpty(message = "Não pode ser vazio")
    @Pattern(regexp = "^[A-Z]\\w+", message = "A primeira letra do nome deve ser maiúscula")
    @Size(max = 45, message = "Não pode ter mais que 45 caracteres")
    private String prop_name;

    @NotNull(message = "Não pode ser null")
    @NotEmpty(message = "Não pode ser vazio")
    @Size(max = 45, message = "Não pode ter mais que 45 caracteres")
    private String prop_district;
    private List<RoomForm> prop_rooms;

    public PropertyForm(String prop_name, String prop_district, List<RoomForm> prop_rooms) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.prop_rooms = prop_rooms;
    }

    public String getProp_name() {
        return prop_name;
    }

    public String getProp_district() {
        return prop_district;
    }

    public List<RoomForm> getProp_rooms() {
        return prop_rooms;
    }
}
