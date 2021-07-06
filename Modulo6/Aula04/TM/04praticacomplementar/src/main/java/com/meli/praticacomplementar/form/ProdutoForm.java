package com.meli.praticacomplementar.form;

import java.util.List;

public class ProdutoForm {
    private String nome;
    private List<CategoriaForm> categorias;
    private Double preco;
    private Integer quantidade;

    public ProdutoForm() {
    }

    public ProdutoForm(String nome, List<CategoriaForm> categorias, Double preco, Integer quantidade) {
        this.nome = nome;
        this.categorias = categorias;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public List<CategoriaForm> getCategorias() {

        return categorias;
    }

    public Double getPreco() {

        return preco;
    }

    public Integer getQuantidade() {

        return quantidade;
    }
}
