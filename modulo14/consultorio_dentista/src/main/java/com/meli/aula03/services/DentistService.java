package com.meli.aula03.services;

import com.meli.aula03.entities.Dentist;
import com.meli.aula03.repositories.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class DentistService {
    @Autowired
    private DentistRepository repository;

    public DentistService(DentistRepository repository) {
        this.repository = repository;
    }

    public void saveDentist(Dentist dentist) {
        repository.save(dentist);
    }

    public void deleteDentist(Long id) {
        repository.deleteById(id);
    }

    public List<Dentist> getAll() {
        return repository.findAll();
    }

    public List<Dentist> getAllByDayHavingTwoMore(LocalDate day) {
        return repository.findDentistsByTurnsDayHavingTwoMore(day);
    }

    public Dentist getDentistById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void populateTable() {
        Dentist dentisty1 = new Dentist("Francisco","Tiradentes","Minas Gerais","oshee",LocalDate.of(1892, Month.APRIL, 14),"+553598787521","","A123456a");
        Dentist dentisty2 = new Dentist("Celso","Rodriguez","São Caetano do Sul","oshee",LocalDate.of(1992, Month.AUGUST, 5),"+551696887421","celso.coringao@hotmail.com","B123456b");

        saveDentist(dentisty1);
        saveDentist(dentisty2);

    }
}
