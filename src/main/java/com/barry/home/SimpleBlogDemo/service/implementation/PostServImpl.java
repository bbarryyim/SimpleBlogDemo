package com.barry.home.SimpleBlogDemo.service.implementation;

import com.barry.home.SimpleBlogDemo.model.*;
import com.barry.home.SimpleBlogDemo.repo.PostRepo;
import com.barry.home.SimpleBlogDemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServImpl implements PostService {

    private final PostRepo postRepo;

    @Autowired
    public PostServImpl(PostRepo postRepo){
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> findForId(Long id) {
        return postRepo.findAllById(id);
    }

    @Override
    public Post getOne(Long id) {
        return postRepo.getOne(id);
    }

    @Override
    public List<Post> findAll(){
        return postRepo.findAll();
    }

    @Override
    public Post save(Post post) {
        return postRepo.saveAndFlush(post);
    }

    @Override
    public void delete(Post post) {
        postRepo.delete(post);
    }
}
