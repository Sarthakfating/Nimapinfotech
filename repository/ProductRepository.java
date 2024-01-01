package com.nimapinfotech.javamachinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimapinfotech.javamachinetest.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
