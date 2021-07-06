package br.com.meli.starwars.dto;

import java.util.List;

public class CharacterDTO {
    private List<String> names;

    public CharacterDTO() {
    }

    public CharacterDTO(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }
}
