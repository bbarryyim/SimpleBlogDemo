package com.barry.home.SimpleBlogDemo.controller;

import com.barry.home.SimpleBlogDemo.SimpleBlogDemoApplication;
import com.barry.home.SimpleBlogDemo.model.Post;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SimpleBlogDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BlogPostControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testGetPost(){
        Assert.assertEquals(200, getPost().getStatusCodeValue());
    }

    @Test
    public void testPostPost(){
        Post post = new Post("title", "body","username");
        System.out.println(postPost(post));
    }

    private ResponseEntity<String> getPost(){
        URI targetUrl = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("127.0.0.1")
                .port(port)
                .pathSegment("createPost","")
                .build()
                .toUri();
        return restTemplate.getForEntity(targetUrl, String.class);
    }

    private String postPost(Post post) {
        URI targetUrl = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("127.0.0.1")
                .port(port)
                .pathSegment("createPost", "")
                .build()
                .toUri();
        return restTemplate.postForObject(targetUrl, post, String.class);
    }

}
