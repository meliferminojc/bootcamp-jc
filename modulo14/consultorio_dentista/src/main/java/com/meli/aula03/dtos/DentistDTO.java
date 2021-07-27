package com.meli.aula03.dtos;

import com.meli.aula03.entities.Dentist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class DentistDTO {
    private String name;

    private String last_name;

    private String address;

    private String dni;

    private LocalDate birth_date;

    private String phone;

    private String email;

    private String code_mp;

    private List<DiaryDTO> diarys = new ArrayList<>();


    public DentistDTO(Dentist d) {
        this.name = d.getName();
        this.last_name = d.getLast_name();
        this.address = d.getAddress();
        this.dni = d.getDni();
        this.birth_date = d.getBirth_date();
        this.phone = d.getPhone();
        this.email = d.getEmail();
        this.code_mp = d.getCode_mp();

        d.getDiarys().forEach(x -> this.diarys.add(DiaryDTO.classToDto(x)));

    }

    public static DentistDTO classToDto(Dentist d) {
        return d == null ? null : new DentistDTO(d);
    }
}
