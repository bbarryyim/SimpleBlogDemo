package com.barry.home.SimpleBlogDemo.repo;

import com.barry.home.SimpleBlogDemo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAllById(Long id);

    Post getOne(Long id);
}
