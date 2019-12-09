package com.barry.home.SimpleBlogDemo.controller;

import com.barry.home.SimpleBlogDemo.model.Post;
import com.barry.home.SimpleBlogDemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    private final PostService postService;

    @Autowired
    public HomeController(PostService postService){
        this.postService = postService;
    }

    @RequestMapping("home")
    public String index(Model model) {
        List<Post> allPosts = postService.findAll();
        model.addAttribute("allPosts", allPosts);
        return "home";
    }

}
