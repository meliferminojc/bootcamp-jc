package com.meli.aula03.repositories;

import com.meli.aula03.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    public List<Patient> findPatientsByTurnsDay(LocalDate date);

}