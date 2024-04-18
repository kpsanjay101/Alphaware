package com.alphaware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphaware.service.DisLikesService;
import com.alphaware.service.LikeService;

@RestController
@RequestMapping("/api/likes/dislikes")
public class LikesAndDisLikesController {
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private DisLikesService dislikeService;
	
	@PostMapping("/likeThePost{PostsId}/{userId}")
	public ResponseEntity<String> likeThePost(@PathVariable Integer PostsId, @PathVariable Integer userId){
		
		return new ResponseEntity<>(likeService.likeThePost(PostsId, userId) , HttpStatus.OK);
		
	}

	@PostMapping("/dislikeThePost{PostsId}/{userId}")
	public ResponseEntity<String> disLikePosts(@PathVariable Integer PostsId, @PathVariable Integer userId){
		
		return new ResponseEntity<>(dislikeService.disLikeThePost(PostsId, userId) , HttpStatus.OK);
		
	}
}
