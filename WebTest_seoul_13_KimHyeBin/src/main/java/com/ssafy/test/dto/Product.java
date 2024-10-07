package com.ssafy.test.dto;


public class Product {
	private String code;
	private String name;
	private Integer quantity;
	private String category;

	public Product() {
	}

	public Product(String name, Integer quantity, String category) {
		this.name = name;
		this.quantity = quantity;
		this.category = category;
	}
	
	public Product(String code, String name, Integer quantity, String category) {
		this(name, quantity, category);
		this.code = code;

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", quantity=" + quantity + ", category=" + category + "]";
	}
	
	

}
