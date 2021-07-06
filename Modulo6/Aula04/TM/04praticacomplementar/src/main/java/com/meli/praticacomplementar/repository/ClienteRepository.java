package com.meli.praticacomplementar.repository;

import com.meli.praticacomplementar.entity.Cliente;
import com.meli.praticacomplementar.entity.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {
    List<Cliente> clientes = new ArrayList<>();
    List<Produto> produtos = new ArrayList<>();

    public List<Cliente> getAllClientes() {
        return clientes;
    }

    public Cliente addCliente(Cliente cliente) {
        cliente.setId((long) clientes.size());
        clientes.add(cliente);
        return cliente;
    }

    public Produto addProduto(Produto produto) {
        produto.setId((long) produtos.size());
        produtos.add(produto);
        return produto;
    }

    public List<Produto> getAllProdutos() {
        return produtos;
    }

    public void updateProduto(long id, Produto produto) {
        Optional<Produto> produtoOptional = produtos.stream().filter(p -> p.getId().equals(id)).findFirst();

        if(produtoOptional.isPresent()) {
            produtos.remove(produtoOptional.get());
            produtos.add(produto);
        }
    }

    public void deleteProduto(long id) {
        Optional<Produto> produtoOptional = produtos.stream().filter(p -> p.getId().equals(id)).findFirst();


        produtoOptional.ifPresent(produto -> produtos.remove(produto));
    }
}