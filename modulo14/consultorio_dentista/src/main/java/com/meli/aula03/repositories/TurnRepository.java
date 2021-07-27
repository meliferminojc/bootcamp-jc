package com.meli.aula03.repositories;

import com.meli.aula03.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {

    public List<Turn> findTurnsByTurnStatusNameEquals(String status);

    public List<Turn> findTurnsByDayBeforeAndTurnStatusNameEquals(LocalDate yesterday, String status);

    @Query("select t " +
            "from Turn t join Turn tr on t.reprogramedTurn.idTurn = tr.idTurn "+
            "order by t.day")
    public List<Turn> findReprogrammedTurns();

    @Query("select t " +
            "from Turn t join Turn tr on t.reprogramedTurn.idTurn = tr.idTurn "+
            "join Diary d on t.diary.id_diary = d.id_diary " +
            "where d.dentist.idDentist = :idDentist " +
            "order by t.day")
    public List<Turn> findReprogrammedTurnsByDentist(@Param("idDentist") Long idDentist);

}