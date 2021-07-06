package com.meli.praticacomplementar.converter;

import com.meli.praticacomplementar.dtos.CategoriaDTO;
import com.meli.praticacomplementar.entity.Categoria;
import com.meli.praticacomplementar.form.CategoriaForm;

import java.util.ArrayList;
import java.util.List;

public class CategoriaConverter {
    public static Categoria categoriaFormToEntity(CategoriaForm categoriaForm) {
        return new Categoria(categoriaForm.getNome());
    }

    public static List<Categoria> categoriaFormToEntity(List<CategoriaForm> categoriaForm) {
        List<Categoria> categorias = new ArrayList<>();

        categoriaForm.forEach(cf -> categorias.add(categoriaFormToEntity(cf)));

        return categorias;
    }

    public static CategoriaDTO categoriaEntityToDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getNome());
    }

    public static List<CategoriaDTO> categoriaEntityToDTO(List<Categoria> categorias) {
        List<CategoriaDTO> categoriaDTOS = new ArrayList<>();

        categorias.forEach(categoria -> categoriaDTOS.add(categoriaEntityToDTO(categoria)));

        return categoriaDTOS;
    }
}
