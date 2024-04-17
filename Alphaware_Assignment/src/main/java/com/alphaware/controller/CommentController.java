package com.alphaware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphaware.model.Comment;
import com.alphaware.model.Posts;
import com.alphaware.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("create_comment/{userId}/{postId}")
	public ResponseEntity<Comment> createComment(@PathVariable Integer userId, @PathVariable Integer postId, @RequestBody Comment comment){
		
		return new ResponseEntity<>(commentService.createComment(userId, postId, comment) , HttpStatus.OK);
		
	}
	

	@DeleteMapping("delete_comment/{commentId}")
	public ResponseEntity<Comment> deletePosts(@PathVariable Integer commentId){
		
		return new ResponseEntity<>(commentService.deleteComment(commentId),HttpStatus.OK);
		
	}

	@PatchMapping("/update_comment/{commentId}")
	public ResponseEntity<Comment> updatePosts(@PathVariable Integer commentId, @RequestBody Comment comment){
		
		return new ResponseEntity<>(commentService.updateComment(commentId, comment) ,HttpStatus.OK);
		
	}
	
	@GetMapping("/getComments/{postId}")
	public ResponseEntity<List<Comment>> getAllCommentSByPostId(@PathVariable Integer postId){
		
		return new ResponseEntity<List<Comment>>(commentService.getAllCommentByPostId(postId), HttpStatus.OK) ;
	}
}
