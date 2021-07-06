package br.com.meli.calculadorametrosquadrados.services;

import br.com.meli.calculadorametrosquadrados.entities.Casa;
import br.com.meli.calculadorametrosquadrados.entities.Comodo;
import br.com.meli.calculadorametrosquadrados.repositories.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasaService {
    @Autowired
    private CasaRepository casaRepository;

    public CasaService() {}

    public CasaService(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    public List<Casa> findAll() {
        return this.casaRepository.getCasas();
    }

    public Double getValorCasa(Long casaId) {
        return this.casaRepository.valorCasa(casaId);
    }

    public List<Comodo> getComodos(Long casaId) {
        return this.casaRepository.getComodos(casaId);
    }

    public Comodo getMaiorComodo(Long casaId) {
        return this.casaRepository.getMaiorComodo(casaId);
    }

    public void add(Casa casa) {
        this.casaRepository.create(casa);
    }
}
