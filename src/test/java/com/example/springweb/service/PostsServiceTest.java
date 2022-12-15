package com.example.springweb.service;

import com.example.springweb.domain.posts.Posts;
import com.example.springweb.domain.posts.PostsMainResponseDto;
import com.example.springweb.domain.posts.PostsRepository;
import com.example.springweb.domain.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void DTO데이터를_posts테이블에_저장() {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("gun")
                .content("just test content")
                .title("this is title")
                .build();

        //when
        Long postId = postsService.save(dto);

        //then
        Posts posts = postsRepository.findById(postId).get();
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

    @Test
    public void 데이터의_역순저장_확인() {
        //given
        //가장 최근에 입력한 데이터
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("gun")
                .content("just test content")
                .title("this is title")
                .build();

        //when
        Long postId = postsService.save(dto);

        //then
        //findAllDesc()가 데이터를 역순으로 가져온다.
        //따라서, 첫 데이터가 최근에 입력한 데이터가 된다.
        List<PostsMainResponseDto> dtos = postsService.findAllDesc();
        PostsMainResponseDto firstDto = dtos.get(0);
        assertThat(firstDto.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(firstDto.getTitle()).isEqualTo(dto.getTitle());
    }
}
