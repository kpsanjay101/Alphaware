package com.alphaware.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphaware.model.Likes;

public interface LikeRepository extends JpaRepository<Likes, Integer>{
	
	Optional<Likes> findByUserIdAndPostId(int userId, int postId);

}
