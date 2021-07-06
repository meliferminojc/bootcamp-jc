package com.meli.praticacomplementar.converter;

import com.meli.praticacomplementar.dtos.ClienteDTO;
import com.meli.praticacomplementar.entity.Cliente;
import com.meli.praticacomplementar.form.ClienteForm;

import java.util.ArrayList;
import java.util.List;

public class ClienteConverter {
    public static Cliente clienteFormToEntity(ClienteForm clienteForm) {
        return new Cliente(
                PedidoConverter.pedidoFormToEntity(clienteForm.getPedidos()),
                clienteForm.getTipo()
                );
    }

    public static List<Cliente> clienteFormToEntity(List<ClienteForm> clienteForms) {
        List<Cliente> clientes = new ArrayList<>();

        for (ClienteForm clienteForm : clienteForms) {
            clientes.add(clienteFormToEntity(clienteForm));
        }

        return clientes;
    }

    public static ClienteDTO clienteEntityToDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getTipo(),
                PedidoConverter.pedidoEntityToDTO(cliente.getPedidos())
        );
    }

    public static List<ClienteDTO> clienteEntityToDTO(List<Cliente> clientes) {
        List<ClienteDTO> clienteDTOS = new ArrayList<>();

        for (Cliente cliente : clientes) {
            clienteDTOS.add(clienteEntityToDTO(cliente));
        }

        return clienteDTOS;
    }
}
