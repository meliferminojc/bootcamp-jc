package br.com.meli.starwars.controller;

import br.com.meli.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starwars")
public class CharacterController {

    private CharacterService characterService;

    public CharacterController(){}

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/characters/{name}")
    public ResponseEntity<?> getNomesPersonagens(@PathVariable String name) {
        return ResponseEntity.ok(characterService.nameCharacters(name));
    }
}
