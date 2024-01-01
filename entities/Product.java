package com.nimapinfotech.javamachinetest.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Product {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 private String name;
 private Long cost;
 private Long discount;

 @ManyToOne
 @JoinColumn(name = "category_id", nullable = false)
 @JsonBackReference
 private Category category;

public Product() {
	super();
	
}

public Product(Long id, String name, Long cost, Long discount, Category category) {
	this.id = id;
	this.name = name;
	this.cost = cost;
	this.discount = discount;
	this.category = category;
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

public Long getCost() {
	return cost;
}

public void setCost(Long cost) {
	this.cost = cost;
}

public Long getDiscount() {
	return discount;
}

public void setDiscount(Long discount) {
	this.discount = discount;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", discount=" + discount + ", category="
			+ category + "]";
}

 
}

