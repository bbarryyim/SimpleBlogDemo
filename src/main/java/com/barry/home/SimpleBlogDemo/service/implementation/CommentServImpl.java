package com.barry.home.SimpleBlogDemo.service.implementation;

import com.barry.home.SimpleBlogDemo.model.Comment;
import com.barry.home.SimpleBlogDemo.repo.CommentRepo;
import com.barry.home.SimpleBlogDemo.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServImpl implements CommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentServImpl.class);

    private final CommentRepo commentRepo;

    @Autowired
    public CommentServImpl(CommentRepo commentRepo){
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment save(Comment comment){
        logger.info("Comment saved, and data flushed to DB.");
        return commentRepo.saveAndFlush(comment);
    }
}
