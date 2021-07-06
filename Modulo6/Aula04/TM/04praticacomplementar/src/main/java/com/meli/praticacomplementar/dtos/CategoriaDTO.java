package com.meli.praticacomplementar.dtos;

public class CategoriaDTO {
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}