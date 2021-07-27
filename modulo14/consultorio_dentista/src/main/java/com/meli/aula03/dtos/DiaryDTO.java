package com.meli.aula03.dtos;

import com.meli.aula03.entities.Diary;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class DiaryDTO {
    private LocalDateTime start_time;
    private LocalDateTime ending_time;
    private List<TurnDTO> turns = new ArrayList<>();

    public DiaryDTO(Diary d) {
        this.start_time = d.getStart_time();
        this.ending_time = d.getEnding_time();
        d.getTurns().forEach(x -> this.turns.add(TurnDTO.classToDto(x)));
    }

    public static DiaryDTO classToDto(Diary d) {
        return new DiaryDTO(d);
    }
}
