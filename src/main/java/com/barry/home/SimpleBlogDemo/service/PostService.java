package com.barry.home.SimpleBlogDemo.service;

import com.barry.home.SimpleBlogDemo.model.*;

import java.util.List;

public interface PostService {

    Post save(Post post);

    Post getOne(Long id);

    List<Post> findAll();

    void delete(Post post);
}
