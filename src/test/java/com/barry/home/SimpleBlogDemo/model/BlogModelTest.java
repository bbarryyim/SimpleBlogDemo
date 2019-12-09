package com.barry.home.SimpleBlogDemo.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BlogModelTest {

    @Autowired
    private TestEntityManager testEntityManager;

    private Post post;
    private Comment comment;

    private Post secondPost;
    private Comment secondComment;
    private Comment thirdComment;

    @Before
    public void setup(){
        post = new Post("title", "body","username");
        comment = new Comment("body of comment", post);
        secondPost = new Post("title2", "body2","username2");
        secondComment = new Comment("2 body of comment", secondPost);
    }

    @Test
    public void savedPostRetrieveId(){
        Post savedPost = this.testEntityManager.persistAndFlush(post);
        assertThat(savedPost.getId()).isBetween(1L,20L);
    }


    @Test
    public void savePostRetrieveBody() {
        Post savedPost = this.testEntityManager.persistAndFlush(post);
        assertThat(savedPost.getBody()).isEqualTo("body");
    }

    @Test
    public void savedPostRetrieveTitle() {
        Post savedPost = this.testEntityManager.persistAndFlush(post);
        assertThat(savedPost.getTitle()).isEqualTo("title");
    }

    @Test
    public void savedPostRetrieveUsername() {
        Post savedPost = this.testEntityManager.persistAndFlush(post);
        assertThat(savedPost.getUsername()).isEqualTo("username");
    }

    @Test
    public void savedPostRetrieveDate() {
        Date current = new Date();
        Post savedPost = this.testEntityManager.persistAndFlush(post);
        assertThat(savedPost.getCreateDate()).isEqualToIgnoringMinutes(current);
    }

    @Test
    public void savedCommentRetrieveId(){
        Post savedPost = this.testEntityManager.persistAndFlush(post);
        Post savedSecondPost = this.testEntityManager.persistAndFlush(secondPost);
        Comment savedComment = this.testEntityManager.persistAndFlush(comment);
        Comment savedSecondComment = this.testEntityManager.persistAndFlush(secondComment);

        assertThat(savedComment.getPost().getId()).isBetween(1L,20L);
        assertThat(savedSecondComment.getPost().getId()).isBetween(1L,20L);
        assertThat(savedComment.getId()).isBetween(1L,20L);
        assertThat(savedSecondComment.getId()).isBetween(1L,20L);
    }

    @Test
    public void savedCommentRetrieveBody(){
        //Persists saved post to avoid transient value
        Post savedPost = this.testEntityManager.persistAndFlush(post);
        Comment savedComment = this.testEntityManager.persistAndFlush(comment);
        assertThat(savedComment.getBody()).isEqualTo("body of comment");
    }

    @Test
    public void savedCommentRetrievePost(){
        Post savedPost = this.testEntityManager.persistAndFlush(post);
        Comment savedComment = this.testEntityManager.persistAndFlush(comment);
        assertThat(savedComment.getPost().getId()).isEqualTo(savedPost.getId());
    }

    @Test
    public void savedCommentRetrieveDate() {
        Date current = new Date();
        Post savedPost = this.testEntityManager.persistAndFlush(post);
        Comment savedComment = this.testEntityManager.persistAndFlush(comment);
        assertThat(savedComment.getCreateDate()).isEqualToIgnoringMinutes(current);
    }


}
