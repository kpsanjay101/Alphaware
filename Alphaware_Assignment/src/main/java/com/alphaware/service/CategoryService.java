package com.alphaware.service;

import java.util.List;

import com.alphaware.model.Category;

public interface CategoryService {
	
   public Category createCategory(int userId,Category category);
	
	public Category deleteCategory(int categoryId);
	
	public Category getCategoryById(int categoryId);
	
	public Category updateCategory(int categoryId,Category category);
	
	public List<Category>  getAllCategory();

}
