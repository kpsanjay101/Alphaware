package com.alphaware.service;

import java.util.List;

import com.alphaware.model.Posts;

public interface PostsService {
	
	Posts createPosts(int userId,int categoryId, Posts posts);
	
	Posts deletePosts(int postId);
	
	Posts getPostsById(int postId);
	
	List<Posts> getAllPosts();
	
	Posts updatePosts(int postId,Posts posts);
	
	List<Posts> getPostsCreatedToday();
	
	List<Posts> getAllPostsByUserId(int userId);
	
	List<Posts> getPostByTitle(String title);
	
	List<Posts> getAllPostByCategoryName(String name);
	
	int allLikesForPost(int postId);
	
	int allDisLikesForPost(int postId);
			
}
