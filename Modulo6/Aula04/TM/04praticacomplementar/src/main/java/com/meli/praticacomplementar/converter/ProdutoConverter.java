package com.meli.praticacomplementar.converter;

import com.meli.praticacomplementar.dtos.ProdutoDTO;
import com.meli.praticacomplementar.entity.Produto;
import com.meli.praticacomplementar.form.ProdutoForm;

import java.util.ArrayList;
import java.util.List;

public class ProdutoConverter {
    public static Produto produtoFormToEntity(ProdutoForm produtoForm) {
        return new Produto(
                produtoForm.getNome(),
                produtoForm.getPreco(),
                produtoForm.getQuantidade(),
                CategoriaConverter.categoriaFormToEntity(produtoForm.getCategorias())
        );
    }

    public static List<Produto> produtoFormToEntity(List<ProdutoForm> produtoForms) {
        List<Produto> produtos = new ArrayList<>();

        for (ProdutoForm produtoForm : produtoForms) {
            produtos.add(produtoFormToEntity(produtoForm));
        }

        return produtos;
    }

    public static ProdutoDTO produtoEntityToDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getNome(),
                CategoriaConverter.categoriaEntityToDTO(produto.getCategorias()),
                produto.getPreco(),
                produto.getQuantidade()
        );
    }

    public static List<ProdutoDTO> produtoEntityToDTO(List<Produto> produtos) {
        List<ProdutoDTO> produtoDTOS = new ArrayList<>();

        for (Produto produto : produtos) {
            produtoDTOS.add(produtoEntityToDTO(produto));
        }

        return produtoDTOS;
    }
}
