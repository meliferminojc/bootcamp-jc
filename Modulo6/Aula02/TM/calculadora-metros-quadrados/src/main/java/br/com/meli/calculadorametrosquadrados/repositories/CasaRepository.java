package br.com.meli.calculadorametrosquadrados.repositories;

import br.com.meli.calculadorametrosquadrados.entities.Casa;
import br.com.meli.calculadorametrosquadrados.entities.Comodo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Repository
public class CasaRepository {

    private static List<Casa> casas = new ArrayList<>();

    public List<Casa> getCasas() {
        return this.casas;
    }

    public void create(Casa casa) {
        casa.setId((long) (casas.size() + 1));
        CasaRepository.casas.add(casa);
    }

    public Double valorCasa(Long id) {
        casas.forEach(c -> System.out.println(c.getNome() + " - " + c.getId()));
        Casa house = casas.stream()
                .filter(casa -> casa.getId().equals(id))
                .findAny()
                .get();

        return house == null ? null : house.getMetrosQuadrados() * 800;
    }

    public Comodo getMaiorComodo(Long casaId) {
        Casa house = casas.stream()
                        .filter(casa -> casa.getId().equals(casaId))
                        .findAny()
                        .get();
        return house.getComodos().stream().max(Comparator.comparing(Comodo::getMetrosQuadrados)).get();
    }

    public List<Comodo> getComodos(Long casaId) {
        Casa house = casas.stream()
                .filter(casa -> casa.getId().equals(casaId))
                .findAny()
                .get();
        return house.getComodos();
    }

}
