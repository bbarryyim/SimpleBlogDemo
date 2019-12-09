package com.barry.home.SimpleBlogDemo.repo;

import com.barry.home.SimpleBlogDemo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}