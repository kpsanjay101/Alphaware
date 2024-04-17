package com.alphaware.service;

import java.util.List;

import com.alphaware.model.Comment;

public interface CommentService {
	
	public Comment createComment(int userId, int postId,Comment comment);
	
	public Comment deleteComment(int commentid);
	
	public Comment updateComment(int commentid,Comment comment);
	
	public List<Comment> getAllCommentByPostId(int postId);
	

}
