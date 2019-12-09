package com.barry.home.SimpleBlogDemo.service.implementation;

import com.barry.home.SimpleBlogDemo.model.*;
import com.barry.home.SimpleBlogDemo.repo.PostRepo;
import com.barry.home.SimpleBlogDemo.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServImpl implements PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostServImpl.class);

    private final PostRepo postRepo;

    @Autowired
    public PostServImpl(PostRepo postRepo){
        this.postRepo = postRepo;
    }

    @Override
    public Post getOne(Long id) {
        logger.info("Find one post with Id: "+ id);
        return postRepo.getOne(id);
    }

    @Override
    public List<Post> findAll(){
        logger.info("Find all posts, in list type");
        return postRepo.findAll();
    }

    @Override
    public Post save(Post post) {
        logger.info("Post saved and data flushed to DB.");
        return postRepo.saveAndFlush(post);
    }

    @Override
    public void delete(Post post) {
        logger.info("Post deleted");
        postRepo.delete(post);
    }
}
