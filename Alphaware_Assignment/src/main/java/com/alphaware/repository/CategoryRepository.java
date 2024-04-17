package com.alphaware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphaware.model.Category;
import com.alphaware.model.Posts;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Category findByName(String name);

}
