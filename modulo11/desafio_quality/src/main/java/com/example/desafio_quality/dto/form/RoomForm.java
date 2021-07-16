package com.example.desafio_quality.dto.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoomForm {
    @NotNull(message = "Não pode ser null")
    @NotEmpty(message = "Não pode ser vazio")
    @Size(max = 45, message = "Não pode ter mais que 45 caracteres")
    private String name;

    @NotNull(message = "Não pode ser null")
    @NotEmpty(message = "Não pode ser vazio")
    @Size(max = 4, message = "Não pode ter mais que 4 caracteres")
    @Min(3)
    private Double width;

    @NotNull(message = "Não pode ser null")
    @NotEmpty(message = "Não pode ser vazio")
    @Size(max = 4, message = "Não pode ter mais que 4 caracteres")
    @Min(3)
    private Double length;

    public RoomForm(String name, Double width, Double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public Double getWidth() {
        return width;
    }

    public Double getLength() {
        return length;
    }
}
