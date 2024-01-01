package com.nimapinfotech.javamachinetest.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 private String name;

 @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
 @JsonManagedReference
 private List<Product> products;

public Category() {
	super();
}

public Category(Long id, String name, List<Product> products) {
	this.id = id;
	this.name = name;
	this.products = products;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

@Override
public String toString() {
	return "Category [id=" + id + ", name=" + name + ", products=" + products + "]";
}

 }
