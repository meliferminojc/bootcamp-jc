package com.meli.aula03.dtos;

import com.meli.aula03.entities.Turn;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class TurnDTO {

    private LocalDate day;

    private String dentist;

    private String patient;

    private String turnStatus;

    private TurnDTO reprogramedTurn;

    public TurnDTO(Turn t) {
        this.day = t.getDay();
        this.turnStatus = t.getTurnStatus().getDescription();
        this.dentist = t.getDiary().getDentist().getName() + " " + t.getDiary().getDentist().getLast_name();
        this.patient = t.getPatient().getName() + " " + t.getPatient().getLast_name();
        this.reprogramedTurn = classToDto(t.getReprogramedTurn());
    }

    public static TurnDTO classToDto(Turn t) {
        return t == null ? null : new TurnDTO(t);
    }
}
