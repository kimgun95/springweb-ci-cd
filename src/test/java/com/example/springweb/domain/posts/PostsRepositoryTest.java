package com.example.springweb.domain.posts;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After("")
    public void clenUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        postsRepository.save(Posts.builder()
                .title("제목")
                .content("내용")
                .author("작가")
                .build());

        // when
        List<Posts> posts = postsRepository.findAll();

        // then
        Posts post = posts.get(0);
        assertThat(post.getTitle(), is("제목"));
        assertThat(post.getContent(), is("내용"));

    }

    @Test
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("제목")
                .content("내용")
                .author("작가")
                .build());

        // when
        List<Posts> posts = postsRepository.findAll();

        // then
        Posts post = posts.get(0);
        assertTrue(post.getCreateDate().isAfter(now));
        assertTrue(post.getModifiedDate().isAfter(now));
    }
}
