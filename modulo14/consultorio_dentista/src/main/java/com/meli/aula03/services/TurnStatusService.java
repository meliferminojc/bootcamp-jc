package com.meli.aula03.services;

import com.meli.aula03.entities.TurnStatus;
import com.meli.aula03.repositories.TurnStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnStatusService {

    @Autowired
    private TurnStatusRepository repository;

    public TurnStatusService(TurnStatusRepository repository) {
        this.repository = repository;
    }

    public void saveTurnStatus(TurnStatus status) {
        repository.save(status);
    }

    public void deletePatient(Long id) {
        repository.deleteById(id);
    }

    public List<TurnStatus> getAll() {
        return repository.findAll();
    }

    public TurnStatus getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void populateTable() {
        TurnStatus turnStatus1 = new TurnStatus("CONCLUIDO", "Concluído");
        TurnStatus turnStatus2 = new TurnStatus("CANCELADO", "Cancelado");
        TurnStatus turnStatus3 = new TurnStatus("PENDENTE", "Pendente");

        saveTurnStatus(turnStatus1);
        saveTurnStatus(turnStatus2);
        saveTurnStatus(turnStatus3);

    }

}
