package com.meli.praticacomplementar.dtos;

import com.meli.praticacomplementar.enums.UsuarioEnum;

import java.util.List;

public class ClienteDTO {
    private UsuarioEnum tipo;
    private List<PedidoDTO> pedidos;

    public ClienteDTO() {
    }

    public ClienteDTO(UsuarioEnum tipo, List<PedidoDTO> pedidos) {
        this.tipo = tipo;
        this.pedidos = pedidos;
    }

    public UsuarioEnum getTipo() {
        return tipo;
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }
}
