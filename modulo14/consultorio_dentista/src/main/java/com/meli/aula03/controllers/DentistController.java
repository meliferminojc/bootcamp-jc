package com.meli.aula03.controllers;

import com.meli.aula03.dtos.DentistDTO;
import com.meli.aula03.dtos.DiaryDTO;
import com.meli.aula03.dtos.PatientDTO;
import com.meli.aula03.dtos.TurnDTO;
import com.meli.aula03.entities.*;
import com.meli.aula03.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private TurnStatusService turnStatusService;

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private TurnService turnService;

    @GetMapping("/dentist")
    public ResponseEntity<?> getDentists() {

        List<DentistDTO> list = new ArrayList<>();

        dentistService.getAll().forEach(x -> list.add(DentistDTO.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @GetMapping("/diary")
    public ResponseEntity<?> getDiary() {

        List<DiaryDTO> list = new ArrayList<>();

        diaryService.getAll().forEach(x -> list.add(DiaryDTO.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @GetMapping("/patients")
    public ResponseEntity<?> getPatients(@RequestParam(required = false, defaultValue = "") String date) {

        List<PatientDTO> list = new ArrayList<>();

        LocalDate lDate = date.isEmpty() ? LocalDate.now() : LocalDate.parse(date);

        patientService.getAllByDay(lDate).forEach(x -> list.add(PatientDTO.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);

    }

    @GetMapping("/dentist/day")
    public ResponseEntity<?> getDentistsByDayHavingTwoMore(@RequestParam(required = false, defaultValue = "") String date) {

        List<DentistDTO> list = new ArrayList<>();

        LocalDate lDate = date.isEmpty() ? LocalDate.now() : LocalDate.parse(date);

        dentistService.getAllByDayHavingTwoMore(lDate).forEach(x -> list.add(DentistDTO.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);

    }

    @GetMapping("/turns/finalized")
    public ResponseEntity<?> getFinalizedTurns() {

        List<TurnDTO> list = new ArrayList<>();

        turnService.getFinalizedTurns().forEach(x -> list.add(TurnDTO.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);

    }

    @GetMapping("/turns/pendent")
    public ResponseEntity<?> getPendentTurns() {

        List<TurnDTO> list = new ArrayList<>();

        turnService.getOneDayPendentTurns().forEach(x -> list.add(TurnDTO.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);

    }

    @GetMapping("/diarys/{idDentist}")
    public ResponseEntity<?> getDiarysByDentist(@PathVariable Long idDentist) {

        List<DiaryDTO> list = new ArrayList<>();

        diaryService.getAllByDentist(dentistService.getDentistById(idDentist)).forEach(x -> list.add(DiaryDTO.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);

    }

    @GetMapping("/turns/reprogrammed/{idDentist}")
    public ResponseEntity<?> getReprogrammedTurnsByDentist(@PathVariable Long idDentist) {

        List<TurnDTO> list = new ArrayList<>();

        turnService.getAllReprogrammedByDentist(idDentist).forEach(x -> list.add(TurnDTO.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @GetMapping("/turns/reprogrammed")
    public ResponseEntity<?> getReprogrammedTurns() {

        List<TurnDTO> list = new ArrayList<>();

        turnService.getAllReprogrammed().forEach(x -> list.add(TurnDTO.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @PostMapping("/turns/reprogram/{idPatient}/{idTurn}")
    public ResponseEntity<?> postReprogramTurn(@PathVariable Long idPatient, @PathVariable Long idTurn, @RequestBody String date) {

        Turn trOld = turnService.getById(idTurn);

        LocalDate lDate = date.isEmpty() ? LocalDate.now().plusMonths(1) : LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);

        Turn trNew = new Turn(lDate, trOld.getDiary(), turnStatusService.getById(3L), trOld.getPatient());

        trOld.setTurnStatus(turnStatusService.getById(2L));
        trNew.setReprogramedTurn(trOld);

        turnService.saveTurn(trOld);
        turnService.saveTurn(trNew);

        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }

    @PostMapping("/populate")
    public ResponseEntity<?> postDatabaseInit() {
        dentistService.populateTable();
        patientService.populateTable();
        turnStatusService.populateTable();
        List<Dentist> dentistsList = dentistService.getAll();
        diaryService.populateTable(dentistsList);

        List<Diary> diaryList = diaryService.getAll();
        List<Patient> patientList = patientService.getAll();
        List<TurnStatus> turnStatusList = turnStatusService.getAll();

        turnService.populateTable(diaryList, turnStatusList, patientList);


        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }
}