package com.alphaware.service;

import java.util.List;

import com.alphaware.model.Comment;

public interface CommentService {
	
	Comment createComment(int userId, int postId,Comment comment);
	
	Comment deleteComment(int commentid);
	
	Comment updateComment(int commentid,Comment comment);
	
	List<Comment> getAllCommentByPostId(int postId);
	

}
