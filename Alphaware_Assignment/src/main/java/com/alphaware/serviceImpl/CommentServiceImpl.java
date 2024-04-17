package com.alphaware.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphaware.exceptions.CommentException;
import com.alphaware.exceptions.PostsException;
import com.alphaware.exceptions.UsersException;
import com.alphaware.model.Comment;
import com.alphaware.model.Posts;
import com.alphaware.model.Users;
import com.alphaware.repository.CommentRepository;
import com.alphaware.repository.PostsRepository;
import com.alphaware.repository.UsersRepository;
import com.alphaware.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@Override
	public Comment createComment(int userId, int postId, Comment comment) {
		
		Optional<Users> userOp =  usersRepository.findById(userId);
		
		Optional<Posts> postOp =  postsRepository.findById(postId);
		
		if(userOp.isPresent() && postOp.isPresent()) {
			
			comment.setUsers(userOp.get());
			comment.setPosts(postOp.get());
//			Posts post = postOp.get();
//			post.getCommentList().add(comment);
//			postsRepository.save(post);
			return  commentRepository.save(comment);
		
		}
		else {
			if(!userOp.isPresent()) {
				throw new UsersException("User doesn't exist with this id "+userId);
			}else {
				throw new PostsException("Post doesn't exist with this id "+postId);
			}
		}

	}

	@Override
	public Comment deleteComment(int commentid) {
		
		Optional<Comment> commOp = commentRepository.findById(commentid);
		
		if(commOp.isPresent()) {
			
			Comment comm = commOp.get();
			commentRepository.deleteById(commentid);
			return comm;
		}else {
			throw new CommentException("Comment doesn't exist with this id "+commentid);
		}
		
	}

	@Override
	public Comment updateComment(int commentid, Comment comment) {
		
        Optional<Comment> commOp = commentRepository.findById(commentid);
		
		if(commOp.isPresent()) {
			
			Comment comm = commOp.get();
			comm.setContent(comment.getContent());
			
			return commentRepository.save(comm);
		}else {
			throw new CommentException("Comment doesn't exist with this id "+commentid);
		}
	}

	@Override
	public List<Comment> getAllCommentByPostId(int postId) {
		
		Optional<Posts> postOp = postsRepository.findById(postId);
		
		if(postOp.isPresent()) {
			
			Posts post = postOp.get();
			List<Comment> comList = commentRepository.findByPostsId(postId);
			if(!comList.isEmpty()) {
				return comList;
			}
			else {
				throw new CommentException("No Comment exist to this post");
			}
		}else {
			throw new PostsException("Posts doesn't exist with this post_id "+postId);
		}

	}

}
