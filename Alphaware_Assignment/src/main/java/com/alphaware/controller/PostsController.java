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
import com.alphaware.model.Posts;
import com.alphaware.service.PostsService;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
	
	@Autowired
	private PostsService postsService;
	
	@PostMapping("/create/{userId}/{categoryId}")
	public ResponseEntity<Posts> createPosts(@PathVariable Integer userId, @PathVariable Integer categoryId, @RequestBody Posts posts){
		
		return new ResponseEntity<Posts>(postsService.createPosts(userId, categoryId, posts) , HttpStatus.OK);
		
	}
	

	@DeleteMapping("/delete/{postId}")
	public ResponseEntity<Posts> deletePosts(@PathVariable Integer postId){
		
		return new ResponseEntity<Posts>(postsService.deletePosts(postId),HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{postId}")
	public ResponseEntity<Posts> getPostsById(@PathVariable Integer postId){
		
		return new ResponseEntity<Posts>(postsService.getPostsById(postId) ,HttpStatus.OK);
		
	}

	@PutMapping("/update/{postId}")
	public ResponseEntity<Posts> updatePosts(@PathVariable Integer postId, @RequestBody Posts posts){
		
		return new ResponseEntity<Posts>(postsService.updatePosts(postId, posts) ,HttpStatus.OK);
		
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Posts>> getAllCategories(){
		
		return new ResponseEntity<>(postsService.getAllPosts() ,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllPostsByUserId/{userId}")
	public ResponseEntity<List<Posts> > getAllPostsByUserId(@PathVariable Integer userId){
		
		return new ResponseEntity<>(postsService.getAllPostsByUserId(userId) ,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllByTitle/{title}")
	public ResponseEntity<List<Posts> > getAllPostsByTitle(@PathVariable String title){
		
		return new ResponseEntity<>(postsService.getPostByTitle(title) ,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllByCategoryName/{name}")
	public ResponseEntity<List<Posts>> getAllPostByCategyName(@PathVariable String name){
		
		return new ResponseEntity<>(postsService.getAllPostByCategoryName(name) ,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllLikes/{postId}")
	public ResponseEntity<Integer> getAllLikesForPosts(@PathVariable Integer postId){
		
		return new ResponseEntity<>(postsService.allLikesForPost(postId) ,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllDisLikes/{postId}")
	public ResponseEntity<Integer> getAllDisLikesForPosts(@PathVariable Integer postId){
		
		return new ResponseEntity<>(postsService.allDisLikesForPost(postId) ,HttpStatus.OK);
		
	}
	
}
