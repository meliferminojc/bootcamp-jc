package com.meli.aula03.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "diary")
@Data
@NoArgsConstructor
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_diary;

    private LocalDateTime start_time;
    private LocalDateTime ending_time;

    @ManyToOne
    @JoinColumn(name = "idDentist", nullable = false)
    private Dentist dentist;

    @OneToMany(mappedBy = "diary")
    private List<Turn> turns;

    public Diary(LocalDateTime start_time, LocalDateTime ending_time, Dentist dentist) {
        this.start_time = start_time;
        this.ending_time = ending_time;
        this.dentist = dentist;
    }
}
