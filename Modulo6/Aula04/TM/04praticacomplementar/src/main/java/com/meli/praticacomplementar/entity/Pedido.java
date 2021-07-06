package com.meli.praticacomplementar.entity;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Long id;
    private List<Produto> produtos = new ArrayList<>();
    private Double total;

    public Pedido(List<Produto> produtos, Double total) {
        this.produtos = produtos;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
