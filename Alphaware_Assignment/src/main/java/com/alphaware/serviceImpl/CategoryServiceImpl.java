package com.alphaware.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphaware.exceptions.CategoryException;
import com.alphaware.exceptions.UsersException;
import com.alphaware.model.Category;
import com.alphaware.model.Users;
import com.alphaware.repository.CategoryRepository;
import com.alphaware.repository.UsersRepository;
import com.alphaware.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private UsersRepository usersRepo;

	@Override
	public Category createCategory(int userId, Category category) {
		
		Optional<Users> userOp = usersRepo.findById(userId);
		
		if(userOp.isPresent()) {
			
			return categoryRepo.save(category);
			
		}else {
			throw new UsersException("User doesn't exist with this id "+userId);
		}

	}

	@Override
	public Category deleteCategory(int categoryId) {
		
		Optional<Category> categoryOp = categoryRepo.findById(categoryId);
		
		if(categoryOp.isPresent()) {
			
			Category category = categoryOp.get();
			categoryRepo.deleteById(categoryId);
			return category;
			
		}
		else {
			throw new CategoryException("Category doesn't exist with this id "+categoryId);
		}
		
	}

	@Override
	public Category getCategoryById(int categoryId) {
		
        Optional<Category> categoryOp = categoryRepo.findById(categoryId);
		
		if(categoryOp.isPresent()) {
			
			return categoryOp.get();
			
		}
		else {
			throw new CategoryException("Category doesn't exist with this id "+categoryId);
		}
	}

	@Override
	public Category updateCategory(int categoryId, Category category) {
		
        Optional<Category> categoryOp = categoryRepo.findById(categoryId);
		
		if(categoryOp.isPresent()) {
			
			Category existcategory = categoryOp.get();
			existcategory.setName(category.getName());
			return categoryRepo.save(existcategory);
			
		}
		else {
			throw new CategoryException("Category doesn't exist with this id "+categoryId);
		}
	}

	@Override
	public List<Category> getAllCategory() {
		
		List<Category> catList = categoryRepo.findAll();
		
		if(!catList.isEmpty()) {
			return catList;
		}
		else {
			throw new CategoryException("There are no category exist");
		}
		
	}

}
