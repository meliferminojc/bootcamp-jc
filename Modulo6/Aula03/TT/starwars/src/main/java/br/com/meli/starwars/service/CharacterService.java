package br.com.meli.starwars.service;

import br.com.meli.starwars.dto.CharacterDTO;
import br.com.meli.starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private CharacterRepository characterRepository;

    public CharacterService() {
    }

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public CharacterDTO nameCharacters(String name) {
        List<String> names = characterRepository.nameCharacters(name);
        return new CharacterDTO(names);
    }
}
