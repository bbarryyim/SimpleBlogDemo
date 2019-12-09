package com.barry.home.SimpleBlogDemo.controller;

import com.barry.home.SimpleBlogDemo.model.Post;
import com.barry.home.SimpleBlogDemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class BlogPostController {
    private final PostService postService;

    @Autowired
    public BlogPostController(PostService postService){
        this.postService = postService;
    }

    @RequestMapping(value = "/createPost", method = RequestMethod.GET)
    public String newPost(Model model){
        Post post = new Post();
        post.setCreateDate(new Date());
        model.addAttribute("post", post);
        return "/blogPostForm";
    }

    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    public String createNewPost(@Valid Post post){
        postService.save(post);
        return "redirect:/blog/"+post.getId();
    }

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable("id") Long id, Model model){
        Post post = postService.getOne(id);
        model.addAttribute("post", post);
        return "/blogPosts";

    }

}
