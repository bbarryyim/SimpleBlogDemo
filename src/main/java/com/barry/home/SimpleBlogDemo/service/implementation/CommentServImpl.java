package com.barry.home.SimpleBlogDemo.service.implementation;

import com.barry.home.SimpleBlogDemo.model.Comment;
import com.barry.home.SimpleBlogDemo.repo.CommentRepo;
import com.barry.home.SimpleBlogDemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServImpl implements CommentService {

    private final CommentRepo commentRepo;

    @Autowired
    public CommentServImpl(CommentRepo commentRepo){
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment save(Comment comment){
        return commentRepo.saveAndFlush(comment);
    }
}
