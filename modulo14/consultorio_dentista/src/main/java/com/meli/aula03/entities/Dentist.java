package com.meli.aula03.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "dentist")
@Data
@NoArgsConstructor
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dentist")
    private Long idDentist;

    private String name;

    private String last_name;

    private String address;

    private String dni;

    private LocalDate birth_date;

    private String phone;

    private String email;

    private String code_mp;

    @OneToMany(mappedBy = "dentist")
    private List<Diary> diarys;

    public Dentist(String name, String last_name, String address, String dni, LocalDate birth_date, String phone, String email, String code_mp) {
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.dni = dni;
        this.birth_date = birth_date;
        this.phone = phone;
        this.email = email;
        this.code_mp = code_mp;
    }
}
