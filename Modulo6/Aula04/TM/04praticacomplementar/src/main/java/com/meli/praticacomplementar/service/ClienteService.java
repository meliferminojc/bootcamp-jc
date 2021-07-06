package com.meli.praticacomplementar.service;

import com.meli.praticacomplementar.converter.ClienteConverter;
import com.meli.praticacomplementar.converter.ProdutoConverter;
import com.meli.praticacomplementar.dtos.ClienteDTO;
import com.meli.praticacomplementar.dtos.ProdutoDTO;
import com.meli.praticacomplementar.entity.Cliente;
import com.meli.praticacomplementar.entity.Produto;
import com.meli.praticacomplementar.enums.UsuarioEnum;
import com.meli.praticacomplementar.exception.AccessException;
import com.meli.praticacomplementar.form.ClienteForm;
import com.meli.praticacomplementar.form.ProdutoForm;
import com.meli.praticacomplementar.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService() {
    }

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> findAllClientes() {
        return ClienteConverter.clienteEntityToDTO(clienteRepository.getAllClientes());
    }

    public Cliente addCliente(ClienteForm clienteForm) {
        return clienteRepository.addCliente(ClienteConverter.clienteFormToEntity(clienteForm));
    }

    public List<ProdutoDTO> findAllProdutos() {
        return ProdutoConverter.produtoEntityToDTO(clienteRepository.getAllProdutos());
    }

    public Produto addProduto(long idCliente, ProdutoForm produtoForm){
        Optional<Cliente> clienteOptional = clienteRepository.getAllClientes().stream().filter(cliente -> cliente.getId().equals(idCliente)).findAny();

        if(clienteOptional.isPresent() && clienteOptional.get().getTipo().equals(UsuarioEnum.ADMIN)) {
            return clienteRepository.addProduto(ProdutoConverter.produtoFormToEntity(produtoForm));
        } else {
            throw new AccessException("Você não tem permissão para adicionar um produto na base de dados!");
        }
    }

    public void updateProduto(long idCliente, long id, ProdutoForm produtoForm) {
        Optional<Cliente> clienteOptional = clienteRepository.getAllClientes().stream().filter(cliente -> cliente.getId() == idCliente).findAny();

        if(clienteOptional.isPresent() && clienteOptional.get().getTipo() == UsuarioEnum.ADMIN) {
            clienteRepository.updateProduto(id, ProdutoConverter.produtoFormToEntity(produtoForm));
        } else {
            throw new AccessException("Você não tem permissão para adicionar um produto na base de dados!");
        }
    }

    public void deleteProduto(long idCliente, long id) {
        Optional<Cliente> clienteOptional = clienteRepository.getAllClientes().stream().filter(cliente -> cliente.getId().equals(idCliente)).findAny();

        if(clienteOptional.isPresent() && clienteOptional.get().getTipo().equals(UsuarioEnum.ADMIN)) {
            clienteRepository.deleteProduto(id);
        } else {
            throw new AccessException("Você não tem permissão para adicionar um produto na base de dados!");
        }
    }
}
