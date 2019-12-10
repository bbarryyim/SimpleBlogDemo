package com.barry.home.SimpleBlogDemo.controller;

import com.barry.home.SimpleBlogDemo.model.Post;
import com.barry.home.SimpleBlogDemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
        model.addAttribute("post", post);
        return "blogPostForm";
    }

    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    public String createNewPost(@Valid Post post, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "blogPostForm";
        }
        else{
            postService.save(post);
            return "redirect:blog/"+post.getId();
        }
    }

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable("id") Long id, Model model){
        Post post = postService.getOne(id);
        if(postService.findAll().contains(post)){
            model.addAttribute("post", post);
            return "blogPosts";
        }
        else{
            return "error";
        }

    }

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    public String deletePost(@PathVariable("id") Long id){
        Post post = postService.getOne(id);
        if(postService.findAll().contains(post)){
            postService.delete(post);
            return "redirect:home";
        }
        else{
            return "error";
        }
    }

}
