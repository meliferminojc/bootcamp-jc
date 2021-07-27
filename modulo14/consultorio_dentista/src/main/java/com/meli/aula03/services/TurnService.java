package com.meli.aula03.services;

import com.meli.aula03.entities.Diary;
import com.meli.aula03.entities.Patient;
import com.meli.aula03.entities.Turn;
import com.meli.aula03.entities.TurnStatus;
import com.meli.aula03.repositories.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class TurnService {

    @Autowired
    private TurnRepository repository;

    public TurnService(TurnRepository repository) {
        this.repository = repository;
    }

    public void saveTurn(Turn turn) {
        repository.save(turn);
    }

    public void deleteTurn(Long id) {
        repository.deleteById(id);
    }

    public List<Turn> getAll() {
        return repository.findAll();
    }

    public List<Turn> getFinalizedTurns() {
        return repository.findTurnsByTurnStatusNameEquals("CONCLUIDO");
    }

    public List<Turn> getOneDayPendentTurns() {
        return repository.findTurnsByDayBeforeAndTurnStatusNameEquals(LocalDate.now(), "PENDENTE");
    }

    public Turn getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Turn> getAllReprogrammed() {
        return repository.findReprogrammedTurns();
    }

    public List<Turn> getAllReprogrammedByDentist(Long id) {
        return repository.findReprogrammedTurnsByDentist(id);
    }

    public void populateTable(List<Diary> diaryList, List<TurnStatus> turnStatusList, List<Patient> patientList) {
        Turn tr1_p1 = new Turn(LocalDate.of(2021, Month.JULY, 24), diaryList.get(0), turnStatusList.get(0), patientList.get(0));
        Turn tr2_p1 = new Turn(LocalDate.of(2021, Month.JUNE, 22), diaryList.get(0), turnStatusList.get(1), patientList.get(0));
        Turn tr3_p1 = new Turn(LocalDate.of(2021, Month.AUGUST, 24), diaryList.get(0), turnStatusList.get(0), patientList.get(0));
        Turn tr4_p1 = new Turn(LocalDate.of(2021, Month.AUGUST, 10), diaryList.get(0), turnStatusList.get(0), patientList.get(0));

        Turn tr1_p2 = new Turn(LocalDate.of(2021, Month.SEPTEMBER, 1), diaryList.get(1), turnStatusList.get(0), patientList.get(1));
        Turn tr2_p2 = new Turn(LocalDate.of(2021, Month.MARCH, 22), diaryList.get(1), turnStatusList.get(1), patientList.get(1));
        Turn tr3_p2 = new Turn(LocalDate.of(2021, Month.APRIL, 10), diaryList.get(1), turnStatusList.get(1), patientList.get(1));
        Turn tr4_p2 = new Turn(LocalDate.of(2021, Month.JULY, 24), diaryList.get(1), turnStatusList.get(0), patientList.get(1));

        Turn tr1_p3 = new Turn(LocalDate.of(2021, Month.JANUARY, 10), diaryList.get(0), turnStatusList.get(1), patientList.get(2));
        Turn tr2_p3 = new Turn(LocalDate.of(2021, Month.FEBRUARY, 5), diaryList.get(0), turnStatusList.get(1), patientList.get(2));
        Turn tr3_p3 = new Turn(LocalDate.of(2021, Month.MAY, 2), diaryList.get(0), turnStatusList.get(1), patientList.get(2));
        Turn tr4_p3 = new Turn(LocalDate.of(2021, Month.JULY, 15), diaryList.get(0), turnStatusList.get(1), patientList.get(2));

        Turn tr1_p4 = new Turn(LocalDate.of(2021, Month.JULY, 24), diaryList.get(1), turnStatusList.get(0), patientList.get(3));
        Turn tr2_p4 = new Turn(LocalDate.of(2021, Month.JULY, 24), diaryList.get(1), turnStatusList.get(1), patientList.get(3));
        Turn tr3_p4 = new Turn(LocalDate.of(2021, Month.AUGUST, 24), diaryList.get(1), turnStatusList.get(0), patientList.get(3));
        Turn tr4_p4 = new Turn(LocalDate.of(2021, Month.SEPTEMBER, 24), diaryList.get(1), turnStatusList.get(0), patientList.get(3));
    }
}
