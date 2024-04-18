package com.alphaware.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphaware.model.DisLikes;


public interface DisLikesRepository extends JpaRepository<DisLikes, Integer>{
	
	Optional<DisLikes> findByUserIdAndPostId(int userId, int postId);

}
