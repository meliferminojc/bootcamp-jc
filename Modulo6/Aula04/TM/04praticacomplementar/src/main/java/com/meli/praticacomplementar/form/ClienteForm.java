package com.meli.praticacomplementar.form;

import com.meli.praticacomplementar.enums.UsuarioEnum;

import java.util.List;

public class ClienteForm {
    private UsuarioEnum tipo;
    private List<PedidoForm> pedidos;

    public ClienteForm() {
    }

    public ClienteForm(UsuarioEnum tipo, List<PedidoForm> pedidos) {
        this.tipo = tipo;
        this.pedidos = pedidos;
    }

    public UsuarioEnum getTipo() {
        return tipo;
    }

    public List<PedidoForm> getPedidos() {
        return pedidos;
    }
}
