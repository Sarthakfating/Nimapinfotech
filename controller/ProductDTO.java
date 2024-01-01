package com.nimapinfotech.javamachinetest.controller;

import com.nimapinfotech.javamachinetest.entities.Product;

public class ProductDTO {
	 private Long id;
	    private String name;
	    private Long cost;
	    private Long discount;
	    private CategoryDTO category; 

	   
	    public ProductDTO(Product product, CategoryDTO categoryDTO) {
	        this.id = product.getId();
	        this.name = product.getName();
	        this.cost = product.getCost();
	        this.discount = product.getDiscount();
	        this.category = categoryDTO; 
	    }

	    
	    public CategoryDTO getCategory() {
	        return category;
	    }

	    public void setCategory(CategoryDTO category) {
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
}
