package br.com.meli.calculadorametrosquadrados.entities;

import java.util.ArrayList;
import java.util.List;

public class Casa {
    private Long id = 0L;
    private String nome;
    private String endereco;
    private Double metrosQuadrados;
    private List<Comodo> comodos = new ArrayList<>();

    public Casa(String nome, String endereco, List<Comodo> comodos, Double metrosQuadrados) {
        this.nome = nome;
        this.endereco = endereco;
        this.comodos = comodos;
        this.metrosQuadrados = metrosQuadrados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMetrosQuadrados() {
        return metrosQuadrados;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", metrosQuadrados=" + metrosQuadrados +
                ", comodos=" + comodos +
                '}';
    }
}
