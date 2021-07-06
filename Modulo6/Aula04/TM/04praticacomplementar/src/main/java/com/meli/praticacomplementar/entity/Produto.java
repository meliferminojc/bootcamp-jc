package com.meli.praticacomplementar.entity;

import java.util.List;

public class Produto {
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private List<Categoria> categorias;

    public Produto(String nome, Double preco, Integer quantidade, List<Categoria> categorias) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categorias = categorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", categorias=" + categorias +
                '}';
    }
}
