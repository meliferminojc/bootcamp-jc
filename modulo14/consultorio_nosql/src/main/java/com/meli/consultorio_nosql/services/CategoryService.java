package com.meli.consultorio_nosql.services;

import com.meli.consultorio_nosql.dtos.CategoryDTO;
import com.meli.consultorio_nosql.entities.Category;
import com.meli.consultorio_nosql.forms.CategoryForm;
import com.meli.consultorio_nosql.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CategoryDTO> listAll() {
        return this.categoryRepository.findAll().stream().map(
                category -> modelMapper.map(category, CategoryDTO.class)
        ).collect(Collectors.toList());
    }

    public CategoryDTO find(String id) {
        Optional<Category> category = this.categoryRepository.findById(id);

        return modelMapper.map(category.get(), CategoryDTO.class);
    }

    public CategoryDTO create(CategoryForm categoryForm) {
        Category category = this.categoryRepository.save(modelMapper.map(categoryForm, Category.class));

        return modelMapper.map(category, CategoryDTO.class);
    }

    public CategoryDTO update(CategoryForm categoryForm, String id) {
        Optional<Category> category = this.categoryRepository.findById(id);

        category.ifPresent(value -> value.setName(categoryForm.getName()));

        this.categoryRepository.save(category.get());

        return modelMapper.map(category.get(), CategoryDTO.class);
    }

    public void delete(String id) {
        this.categoryRepository.deleteById(id);
    }
}