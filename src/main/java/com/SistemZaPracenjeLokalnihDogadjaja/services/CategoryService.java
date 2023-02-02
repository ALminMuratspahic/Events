package com.SistemZaPracenjeLokalnihDogadjaja.services;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Category;
import com.SistemZaPracenjeLokalnihDogadjaja.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    public Category findById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new NoSuchElementException("No Catogory with id: " + id));
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
