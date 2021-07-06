package com.meli.praticacomplementar.entity;

import com.meli.praticacomplementar.enums.UsuarioEnum;

import java.util.List;

public class Cliente {
    private Long id;
    private List<Pedido> pedidos;
    private UsuarioEnum tipo;

    public Cliente(List<Pedido> pedidos, UsuarioEnum tipo) {
        this.pedidos = pedidos;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public UsuarioEnum getTipo() {
        return tipo;
    }

    public void setTipo(UsuarioEnum tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", pedidos=" + pedidos +
                ", tipo=" + tipo +
                '}';
    }
}
