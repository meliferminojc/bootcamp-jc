package com.meli.aula03.services;

import com.meli.aula03.entities.Patient;
import com.meli.aula03.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public void savePatient(Patient patient){
        repository.save(patient);
    }

    public void deletePatient(Long id){
        repository.deleteById(id);
    }

    public List<Patient> getAll(){
        return repository.findAll();
    }

    public List<Patient> getAllByDay(LocalDate d){
        return repository.findPatientsByTurnsDay(d);
    }

    public void populateTable() {
        List<Patient> patientList = new ArrayList<>();
        Patient patient1 = new Patient("Joao","Ghordo", "Pirapitingui - SP", "oshee", LocalDate.of(1994, Month.AUGUST, 5), "+551598857431","jao.gordasso@gmail.com");
        Patient patient2 = new Patient("Felipe","Farias", "Caetité - BA", "oshee", LocalDate.of(1994, Month.SEPTEMBER, 5), "+556998857431","f.farias@outlook.com");
        Patient patient3 = new Patient("Beatriz","Knusty", "Criciúma - SC", "oshee", LocalDate.of(1995, Month.JULY, 5), "+554898857431","bia_htinha15@hotmail.com");
        Patient patient4 = new Patient("Giulia","Franco", "Rio Branco - AC", "oshee", LocalDate.of(1992, Month.JULY, 14), "+55739857431","giu_diva@terra.com");

        savePatient(patient1);
        savePatient(patient2);
        savePatient(patient3);
        savePatient(patient4);
    }

}
