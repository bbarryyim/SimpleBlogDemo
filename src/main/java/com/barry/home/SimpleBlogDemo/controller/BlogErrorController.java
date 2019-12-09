package com.barry.home.SimpleBlogDemo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BlogErrorController implements ErrorController {


    @RequestMapping("/error")
    public ModelAndView error() {
        return new ModelAndView("/error");
    }

    @Override
    public String getErrorPath() {
        return "error";
    }
}
