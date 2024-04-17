package com.alphaware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphaware.model.Posts;
import com.alphaware.service.PostsService;

@RestController
@RequestMapping("/api/posts")
public class FeedController {
	
	@Autowired
	private PostsService postsService;
	
	@GetMapping("/today")
    public ResponseEntity<List<Posts>> getPostsCreatedToday() {
        List<Posts> posts = postsService.getPostsCreatedToday();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

}
