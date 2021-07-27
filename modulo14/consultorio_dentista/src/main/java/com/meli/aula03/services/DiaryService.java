package com.meli.aula03.services;

import com.meli.aula03.entities.Dentist;
import com.meli.aula03.entities.Diary;
import com.meli.aula03.entities.Patient;
import com.meli.aula03.repositories.DentistRepository;
import com.meli.aula03.repositories.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


@Service
public class DiaryService {

    @Autowired
    private DiaryRepository repository;

    @Autowired
    private DentistRepository dentistRepository;

    public DiaryService(DiaryRepository repository) {
        this.repository = repository;
    }

    public void saveDiary(Diary diary){
        repository.save(diary);
    }

    public void deleteDiary(Long id){
        repository.deleteById(id);
    }

    public List<Diary> getAll(){
        return repository.findAll();
    }

    public List<Diary> getAllByDentist(Dentist d){
        return repository.findDiariesByDentist(d);
    }

    public void populateTable(List<Dentist> dentistList) {
        Diary diary1 = new Diary(LocalDateTime.of(2021,Month.JULY,24,15,30),LocalDateTime.of(2021,Month.JULY,24,16,00), dentistList.get(0));
        Diary diary2 = new Diary(LocalDateTime.of(2021,Month.JULY,24,16,30),LocalDateTime.of(2021,Month.JULY,24,17,00), dentistList.get(1));


        saveDiary(diary1);
        saveDiary(diary2);

    }
}
