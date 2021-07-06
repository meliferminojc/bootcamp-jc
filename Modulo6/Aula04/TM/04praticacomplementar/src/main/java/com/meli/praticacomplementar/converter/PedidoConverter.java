package com.meli.praticacomplementar.converter;

import com.meli.praticacomplementar.dtos.PedidoDTO;
import com.meli.praticacomplementar.entity.Pedido;
import com.meli.praticacomplementar.form.PedidoForm;
import com.meli.praticacomplementar.form.ProdutoForm;

import java.util.ArrayList;
import java.util.List;

public class PedidoConverter {
    public static Pedido pedidoFormToEntity(PedidoForm pedidoForm) {
        return new Pedido(
                ProdutoConverter.produtoFormToEntity(pedidoForm.getProdutos()),
                total(pedidoForm.getProdutos())
        );
    }

    public static List<Pedido> pedidoFormToEntity(List<PedidoForm> pedidoForms) {
        List<Pedido> pedidos = new ArrayList<>();

        for (PedidoForm pedidoForm : pedidoForms) {
            pedidos.add(pedidoFormToEntity(pedidoForm));
        }

        return pedidos;
    }

    public static PedidoDTO pedidoEntityToDTO(Pedido pedido) {
        return new PedidoDTO(
                ProdutoConverter.produtoEntityToDTO(pedido.getProdutos()),
                pedido.getTotal()
        );
    }

    public static List<PedidoDTO> pedidoEntityToDTO(List<Pedido> pedidos) {
        List<PedidoDTO> pedidoDTOS = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            pedidoDTOS.add(pedidoEntityToDTO(pedido));
        }

        return pedidoDTOS;
    }

    private static double total(List<ProdutoForm> produtoForms) {
        double value = 0.0;

        for (ProdutoForm produtoForm : produtoForms) {
            value += produtoForm.getPreco() * produtoForm.getQuantidade();
        }

        return value;
    }
}