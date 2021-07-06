package br.com.meli.starwars.repository;

import br.com.meli.starwars.entity.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository {
    private static final File FILE = new File("starwars.json");

    @Autowired
    private ObjectMapper mapper;

    public List<Character> getAll() {
        List<Character> characters = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(FILE);
            TypeReference<List<Character>> typeReference = new TypeReference<>() {};
            characters = mapper.readValue(fileInputStream, typeReference);
            fileInputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }

        return characters;
    }

    public List<String> nameCharacters(String name) {
        List<Character> characters = getAll();
        List<String> names = new ArrayList<>();

        characters.forEach(character -> {
            System.out.println(name);
            System.out.println(character.getName());
            System.out.println(character.getName().equalsIgnoreCase(name));
            if(character.getName().contains(name)) {
                names.add(character.getName());
            }
        });

        return names;
    }
}
