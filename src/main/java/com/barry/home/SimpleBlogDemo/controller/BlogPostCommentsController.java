package com.barry.home.SimpleBlogDemo.controller;

import com.barry.home.SimpleBlogDemo.model.Comment;
import com.barry.home.SimpleBlogDemo.model.Post;
import com.barry.home.SimpleBlogDemo.service.CommentService;
import com.barry.home.SimpleBlogDemo.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class BlogPostCommentsController {

    private static final Logger logger = LoggerFactory.getLogger(BlogPostCommentsController.class);


    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public BlogPostCommentsController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public String createNewComment(@Valid Comment comment, Model model) {
        model.addAttribute("comment", comment);
        commentService.save(comment);
        return "redirect:/blog/" + comment.getPost().getId();

    }

    @RequestMapping(value = "blogComment/{id}", method = RequestMethod.GET)
    public String newComment(@PathVariable("id") Long id, Model model){
        Comment comment = new Comment();
        Post post = postService.getOne(id);
        comment.setPost(post);
        model.addAttribute("comment", comment);
        return "/blogCommentForm";
    }



}
