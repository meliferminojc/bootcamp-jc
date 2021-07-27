package com.meli.aula03.dtos;

import com.meli.aula03.entities.Patient;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class PatientDTO {
    private String name;

    private String last_name;

    private String address;

    private String dni;

    private LocalDate birth_date;

    private String phone;

    private String email;

    private List<TurnDTO> turns = new ArrayList<>();

    public PatientDTO(Patient p) {
        this.name = p.getName();
        this.last_name = p.getLast_name();
        this.address = p.getAddress();
        this.dni = p.getDni();
        this.birth_date = p.getBirth_date();
        this.phone = p.getPhone();
        this.email = p.getEmail();

        p.getTurns().forEach(x -> this.turns.add(TurnDTO.classToDto(x)));

    }

    public static PatientDTO classToDto(Patient p) {
        return p == null ? null : new PatientDTO(p);
    }
}
