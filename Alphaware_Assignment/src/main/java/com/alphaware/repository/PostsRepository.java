package com.alphaware.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphaware.model.Posts;

public interface PostsRepository extends JpaRepository<Posts, Integer>{
	
	List<Posts> findByCreatedAtBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
	
	List<Posts> findAllByUsersId(Integer userId);

	List<Posts> findByTitle(String title);
	
	
}
