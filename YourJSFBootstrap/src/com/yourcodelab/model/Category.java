package com.yourcodelab.model;

public class Category {
	private Integer idcategory;
	private String description;
	
	public Category(Integer idCategory , String description){
		this.idcategory = idCategory;
		this.description = description;
		
	}
	
	public Integer getIdcategory() {
		return idcategory;
	}
	public void setIdcategory(Integer idcategory) {
		this.idcategory = idcategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
