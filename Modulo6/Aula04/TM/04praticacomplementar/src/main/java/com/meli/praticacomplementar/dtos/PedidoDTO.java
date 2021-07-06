package com.meli.praticacomplementar.dtos;

import java.util.List;

public class PedidoDTO {
    private List<ProdutoDTO> produtos;
    private Double total;

    public PedidoDTO() {
    }

    public PedidoDTO(List<ProdutoDTO> produtos, Double total) {
        this.produtos = produtos;
        this.total = total;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public Double getTotal() {
        return total;
    }
}
