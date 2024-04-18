package com.alphaware.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphaware.exceptions.DisLikeException;
import com.alphaware.exceptions.LikeException;
import com.alphaware.model.DisLikes;
import com.alphaware.model.Likes;
import com.alphaware.model.Posts;
import com.alphaware.model.Users;
import com.alphaware.repository.DisLikesRepository;
import com.alphaware.repository.LikeRepository;
import com.alphaware.repository.PostsRepository;
import com.alphaware.repository.UsersRepository;
import com.alphaware.service.DisLikesService;

@Service
public class DisLikesServiceImpl implements DisLikesService{
	
	@Autowired
	private PostsRepository postsRepository;
	
	@Autowired
	private DisLikesRepository disLikeRepository;

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public String disLikeThePost(int postsId, int usersId) {
		Optional<DisLikes> existingLike = disLikeRepository.findByUserIdAndPostId(usersId, postsId);

        if (existingLike.isPresent()) {
            throw new DisLikeException("User has already disliked the post");
        }

        Optional<Users> userOp = usersRepository.findById(usersId);
        Optional<Posts> postOp = postsRepository.findById(postsId);

        if (userOp.isPresent() && postOp.isPresent()) {
            DisLikes like = new DisLikes();
            like.setUser(userOp.get());
            like.setPost(postOp.get());

            disLikeRepository.save(like);

            // Update the like count for the post
            postOp.get().getDisLikesList() .add(like);
            postsRepository.save(postOp.get());

            return ""+postOp.get().getDisLikeCount();
        } else {
            throw new DisLikeException("User or Post not found");
        }
		
		
	}

}
