package com.alphaware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphaware.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	List<Comment> findByPostsId(int postId);
	
}
