package com.alphaware.service;

import java.util.List;

import com.alphaware.model.Posts;

public interface PostsService {
	
	public Posts createPosts(int userId,int categoryId, Posts posts);
	
	public Posts deletePosts(int postId);
	
	public Posts getPostsById(int postId);
	
	public List<Posts> getAllPosts();
	
	public Posts updatePosts(int postId,Posts posts);
	
	public List<Posts> getPostsCreatedToday();
	
	public List<Posts> getAllPostsByUserId(int userId);
	
	public List<Posts> getPostByTitle(String title);
	
	public List<Posts> getAllPostByCategoryName(String name);
	
	
}
