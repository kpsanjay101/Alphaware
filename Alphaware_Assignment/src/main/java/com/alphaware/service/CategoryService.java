package com.alphaware.service;

import java.util.List;

import com.alphaware.model.Category;

public interface CategoryService {
	
    Category createCategory(int userId,Category category);
	
	Category deleteCategory(int categoryId);
	
	Category getCategoryById(int categoryId);
	
	Category updateCategory(int categoryId,Category category);
	
	List<Category>  getAllCategory();

}
