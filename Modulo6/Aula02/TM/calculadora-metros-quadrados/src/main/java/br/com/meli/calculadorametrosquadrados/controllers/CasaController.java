package br.com.meli.calculadorametrosquadrados.controllers;

import br.com.meli.calculadorametrosquadrados.entities.Casa;
import br.com.meli.calculadorametrosquadrados.entities.Comodo;
import br.com.meli.calculadorametrosquadrados.services.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casa")
public class CasaController {

    @Autowired
    private CasaService casaService;

    @Autowired
    public CasaController(CasaService casaService) { this.casaService = casaService; }

    public CasaController(){}

    @GetMapping("/value/{id}")
    public ResponseEntity<?> getCasaValue(@PathVariable Long id){
        Double valor = casaService.getValorCasa(id);

        return valor.isNaN()
                ? ResponseEntity.badRequest().body("Casa não encontrada")
                : ResponseEntity.ok().body(valor);
    }

    @GetMapping("/find")
    public ResponseEntity<?> findCasa() {
        List<Casa> casas = casaService.findAll();

        return casas.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(casas);
    }

    @GetMapping("/find/comodos/{casaId}")
    public ResponseEntity<?> getComodos(@PathVariable Long casaId) {
        List<Comodo> comodos = casaService.getComodos(casaId);

        return comodos.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(comodos);
    }

    @GetMapping("/find/comodo/{casaId}")
    public ResponseEntity<?> getComodo(@PathVariable Long casaId) {
        Comodo comodo = casaService.getMaiorComodo(casaId);


        return comodo.equals(null)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(comodo);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createCasa(@RequestBody Casa casa) {
        casaService.add(casa);

        return ResponseEntity.ok().build();
    }

}
