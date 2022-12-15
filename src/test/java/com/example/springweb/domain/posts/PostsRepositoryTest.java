package com.example.springweb.domain.posts;

import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
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
        // given, 가장 최근에 저장한 글
        postsRepository.save(Posts.builder()
                .title("제목")
                .content("내용")
                .author("작가")
                .build());

        // when, 게시글을 전부 탐색하게 되면
        List<Posts> posts = postsRepository.findAll();

        // then, 가장 마지막 post가 최근에 저장한 글이다
        Posts post = posts.get(posts.size() - 1);
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
        Posts post = posts.get(posts.size() - 1);
        assertTrue(post.getCreatedDate().isAfter(now));
        assertTrue(post.getModifiedDate().isAfter(now));
    }

    @Test
    public void 초기데이터_확인하기() {
        //given, 해당 post는 data-h2.sql에서 첫 번째로 insert 되는 데이터이다.
        Posts post = Posts.builder()
                .title("테스트1")
                .author("test1@gmail.com")
                .content("테스트1의 본문")
                .build();

        //when
        List<Posts> posts = postsRepository.findAll();

        //then
        Posts firstPost = posts.get(0);
        Assertions.assertThat(firstPost.getAuthor()).isEqualTo(post.getAuthor());
        Assertions.assertThat(firstPost.getContent()).isEqualTo(post.getContent());
        Assertions.assertThat(firstPost.getTitle()).isEqualTo(post.getTitle());
    }
}
