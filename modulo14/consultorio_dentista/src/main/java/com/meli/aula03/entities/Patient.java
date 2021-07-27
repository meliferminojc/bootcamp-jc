package com.meli.aula03.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_patient;

    private String name;

    private String last_name;

    private String address;

    private String dni;

    private LocalDate birth_date;

    private String phone;

    private String email;

    @OneToMany(mappedBy = "patient")
    private List<Turn> turns;

    public Patient(String name, String last_name, String address, String dni, LocalDate birth_date, String phone, String email) {
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.dni = dni;
        this.birth_date = birth_date;
        this.phone = phone;
        this.email = email;
    }
}
