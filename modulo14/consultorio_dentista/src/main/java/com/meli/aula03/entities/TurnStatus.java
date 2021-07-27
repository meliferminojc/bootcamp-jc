package com.meli.aula03.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "turn_status")
@Data
@NoArgsConstructor
public class TurnStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turn_status;

    private String name;

    private String description;

    @OneToMany(mappedBy = "turnStatus")
    private List<Turn> turns;

    public TurnStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
