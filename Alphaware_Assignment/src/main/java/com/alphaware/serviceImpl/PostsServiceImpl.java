package com.alphaware.serviceImpl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphaware.exceptions.CategoryException;
import com.alphaware.exceptions.PostsException;
import com.alphaware.exceptions.UsersException;
import com.alphaware.model.Category;
import com.alphaware.model.Posts;
import com.alphaware.model.Users;
import com.alphaware.repository.CategoryRepository;
import com.alphaware.repository.PostsRepository;
import com.alphaware.repository.UsersRepository;
import com.alphaware.service.PostsService;

@Service
public class PostsServiceImpl implements PostsService{
	
	@Autowired
	private PostsRepository postRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private UsersRepository usersRepo;
	

	@Override
	public Posts createPosts(int userId, int categoryId, Posts posts) {
		
		Optional<Users> userOp = usersRepo.findById(userId);
		
		Optional<Category> categoryOp = categoryRepo.findById(categoryId);
		
		if(userOp.isPresent() && categoryOp.isPresent()) {
			
			Users user = userOp.get();
			
			Category category = categoryOp.get();
			
			posts.setUsers(user);
			posts.setCategory(category);
			
			return postRepo.save(posts);
			
		}
		else {
			if(!userOp.isPresent()) {
				throw new UsersException("User doesn't exist with this id "+userId);
			}else {
				throw new CategoryException("Category doesn't exist with this id "+userId);
			}
		}

	}

	@Override
	public Posts deletePosts(int postId) {
		
		 Optional<Posts> postOp = postRepo.findById(postId);
		
		if(postOp.isPresent()) {
			
			postRepo.deleteById(postId);
			return postOp.get();
		}else {
			throw new PostsException("Post doesn't exist with this id "+postId);
		}
				
	}

	@Override
	public Posts getPostsById(int postId) {
		
		Optional<Posts> postOp = postRepo.findById(postId);
		
        if(postOp.isPresent()) {
			
			return postOp.get();
			
		}else {
			throw new PostsException("Post doesn't exist with this id "+postId);
		}
		
	}

	@Override
	public Posts updatePosts(int postId, Posts posts) {
		
       Optional<Posts> postOp = postRepo.findById(postId);
		
        if(postOp.isPresent()) {
			
			Posts existPost = postOp.get();
			existPost.setTitle(posts.getTitle());
			existPost.setContent(posts.getContent());
			
			return postRepo.save(existPost);			
			
		}else {
			throw new PostsException("Post doesn't exist with this id "+postId);
		}
	}

	@Override
	public List<Posts> getAllPosts() {
		
        List<Posts> postList = postRepo.findAll();
		
		if(!postList.isEmpty()) {
			return postList;
		}
		else {
			throw new PostsException("There are no Posts exist at this moment");
		}
	}

	@Override
	public List<Posts> getPostsCreatedToday() {
		
		LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.now().with(LocalTime.MAX);
        
        return postRepo.findByCreatedAtBetween(startOfDay, endOfDay);
	}

	@Override
	public List<Posts> getAllPostsByUserId(int userId) {
		
		List<Posts> postList = postRepo.findAllByUsersId(userId);
		
		if(!postList.isEmpty()) {
			return postList;
		}else {
			throw new PostsException("No Posts available at this moment");
		}

	}

	@Override
	public List<Posts> getPostByTitle(String title) {
		
		List<Posts> postList = postRepo.findByTitle(title);
		
		if(!postList.isEmpty()) {
			return postList;
		}else {
			throw new PostsException("Posts isn't available");
		}
		
	}

	@Override
	public List<Posts> getAllPostByCategoryName(String name) {
		
		Category category = categoryRepo.findByName(name);
		
		if(category != null) {
			
			List<Posts> postList = category.getPosts();
			return postList;
		}else {
			throw new PostsException("There is no Posts available with this category name "+name);
		}
		
	}

	@Override
	public int allLikesForPost(int postId) {
		
		Optional<Posts> postOp = postRepo.findById(postId);
		
		if(postOp.isPresent()) {
			
			Posts post = postOp.get();
			return post.getLikeCount();
		}else {
			throw new PostsException("Posts doesn't exist with this id "+postId);
		}
		
	}

	@Override
	public int allDisLikesForPost(int postId) {
		
       Optional<Posts> postOp = postRepo.findById(postId);
		
		if(postOp.isPresent()) {
			
			Posts post = postOp.get();
			return post.getDisLikeCount();
		}else {
			throw new PostsException("Posts doesn't exist with this id "+postId);
		}
	}



}
