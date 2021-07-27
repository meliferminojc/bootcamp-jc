package com.meli.aula03.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turn")
@Data
@NoArgsConstructor
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Long idTurn;

    private LocalDate day;

    @ManyToOne
    @JoinColumn(name = "id_diary", nullable = false)
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "id_turn_status", nullable = false)
    private TurnStatus turnStatus;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;

    @OneToOne
    private Turn reprogramedTurn;

    public Turn(LocalDate day, Diary diary, TurnStatus turnStatus, Patient patient) {
        this.day = day;
        this.diary = diary;
        this.turnStatus = turnStatus;
        this.patient = patient;
    }
}
