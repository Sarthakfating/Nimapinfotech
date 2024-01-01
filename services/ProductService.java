package com.nimapinfotech.javamachinetest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nimapinfotech.javamachinetest.controller.CategoryDTO;
import com.nimapinfotech.javamachinetest.controller.ProductDTO;
import com.nimapinfotech.javamachinetest.entities.Product;
import com.nimapinfotech.javamachinetest.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryService categoryService;

    public ProductDTO getProductDTOById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            CategoryDTO categoryDTO = categoryService.getCategoryDTOById(product.getCategory().getId());
            return new ProductDTO(product, categoryDTO);
        }
        return null;
    }

    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Page<Product> getAllProducts(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public Product updateProduct(Long id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}