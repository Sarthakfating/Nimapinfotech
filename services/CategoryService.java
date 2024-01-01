package com.nimapinfotech.javamachinetest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nimapinfotech.javamachinetest.controller.CategoryDTO;
import com.nimapinfotech.javamachinetest.entities.Category;
import com.nimapinfotech.javamachinetest.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    public CategoryDTO getCategoryDTOById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            return new CategoryDTO(category);
        }
        return null;
    }

    @Transactional
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Page<Category> getAllCategories(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return categoryRepository.findAll(pageable);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Transactional
    public Category updateCategory(Long id, Category updatedCategory) {
        if (categoryRepository.existsById(id)) {
            updatedCategory.setId(id);
            return categoryRepository.save(updatedCategory);
        }
        return null;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}