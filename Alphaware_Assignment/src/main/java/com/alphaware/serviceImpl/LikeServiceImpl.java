package com.alphaware.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphaware.exceptions.LikeException;
import com.alphaware.model.Likes;
import com.alphaware.model.Posts;
import com.alphaware.model.Users;
import com.alphaware.repository.LikeRepository;
import com.alphaware.repository.PostsRepository;
import com.alphaware.repository.UsersRepository;
import com.alphaware.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	private PostsRepository postsRepository;
	
	@Autowired
	private LikeRepository likeRepository;

	@Autowired
	private UsersRepository usersRepository;
	
	
	
	@Override
	public String likeThePost(int postsId, int usersId) {
		
		Optional<Likes> existingLike = likeRepository.findByUserIdAndPostId(usersId, postsId);

        if (existingLike.isPresent()) {
            throw new LikeException("User has already liked the post");
        }

        Optional<Users> userOp = usersRepository.findById(usersId);
        Optional<Posts> postOp = postsRepository.findById(postsId);

        if (userOp.isPresent() && postOp.isPresent()) {
            Likes like = new Likes();
            like.setUser(userOp.get());
            like.setPost(postOp.get());

            likeRepository.save(like);

            // Update the like count for the post
            postOp.get().getLikesList().add(like);
            postsRepository.save(postOp.get());

            return ""+postOp.get().getLikeCount();
        } else {
            throw new LikeException("User or Post not found");
        }
		
		
	}

}
