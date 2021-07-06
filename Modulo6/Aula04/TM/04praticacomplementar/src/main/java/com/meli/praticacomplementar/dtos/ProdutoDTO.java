package com.meli.praticacomplementar.dtos;

import java.util.List;

public class ProdutoDTO {
    private String nome;
    private List<CategoriaDTO> categorias;
    private Double preco;
    private Integer quantidade;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nome, List<CategoriaDTO> categorias, Double preco, Integer quantidade) {
        this.nome = nome;
        this.categorias = categorias;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public List<CategoriaDTO> getCategorias() {
        return categorias;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
