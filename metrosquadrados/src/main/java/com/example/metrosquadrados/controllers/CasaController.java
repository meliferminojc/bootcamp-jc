package com.example.metrosquadrados.controllers;

import com.example.metrosquadrados.dao.CasaDAO;
import com.example.metrosquadrados.dto.CasaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/casa")
public class CasaController {

    @GetMapping()
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(CasaDAO.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable long id) {
        CasaDTO casa = CasaDAO.findById(id);

        if (casa != null) {
            return ResponseEntity.ok(casa);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Casa não encontrada");
    }

    @PostMapping("/nova")
    public ResponseEntity<?> save(@RequestBody CasaDTO casa) {

        return ResponseEntity.status(HttpStatus.CREATED).body(CasaDAO.add(casa));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CasaDTO casa) {
        CasaDTO novaCasa = CasaDAO.update(id, casa);

        if (novaCasa != null) {
            return ResponseEntity.ok(novaCasa);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Casa não encontrada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        CasaDTO casa = CasaDAO.delete(id);

        if (casa != null) {
            return ResponseEntity.ok(casa);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Casa não encontrada");
    }
}
