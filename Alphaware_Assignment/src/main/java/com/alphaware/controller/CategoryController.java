package com.alphaware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphaware.model.Category;
import com.alphaware.model.Posts;
import com.alphaware.service.CategoryService;
import com.alphaware.service.PostsService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("create_category/{userId}")
	public ResponseEntity<Category> createCategory(@PathVariable Integer userId, @RequestBody Category category){
		
		return new ResponseEntity<>(categoryService.createCategory(userId, category) , HttpStatus.OK);
		
	}
	

	@DeleteMapping("delete_category/{categoryId}")
	public ResponseEntity<Category> deleteCategory(@PathVariable Integer categoryId){
		
		return new ResponseEntity<>(categoryService.deleteCategory(categoryId) ,HttpStatus.OK);
		
	}
	
	@GetMapping("get_category/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer categoryId){
		
		return new ResponseEntity<>(categoryService.getCategoryById(categoryId) ,HttpStatus.OK);
		
	}

	@PutMapping("update_category/{categoryId}")
	public ResponseEntity<Category> updateCategory(@PathVariable Integer categoryId, @RequestBody Category category){
		
		return new ResponseEntity<>(categoryService.updateCategory(categoryId, category) ,HttpStatus.OK);
		
	}

	@GetMapping("get_categoryAll")
	public ResponseEntity<List<Category>> getAllCategories(){
		
		return new ResponseEntity<>(categoryService.getAllCategory() ,HttpStatus.OK);
		
	}
}
