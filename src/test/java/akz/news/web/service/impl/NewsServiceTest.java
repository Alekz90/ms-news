package akz.news.web.service.impl;

import akz.news.configuration.FeignConfig;
import akz.news.configuration.RedisConfig;
import akz.news.remote.dto.EverythingResponse;
import akz.news.remote.repository.INewsRtoRepository;
import akz.news.remote.service.NewsRtoService;
import akz.news.utils.TestDataUtils;
import akz.news.web.service.INewsService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = { FeignConfig.class, RedisConfig.class})
@Import({NewsRtoService.class})
@DisplayName("News Service Test")
class NewsServiceTest {

//  @MockitoBean
//  private INewsRtoRepository repositoryMock;
//
//  @MockitoBean
//  private NewsRtoService newsRtoService;
//
//  @Autowired
//  private INewsService service;
//
//  @BeforeEach
//  void setUp() {}
//
//  @AfterEach
//  void tearDown() {
//    reset(repositoryMock);
////    reset(newsRtoService);
//  }
//
//  @Test
//  @DisplayName("Get all news")
//  void getEverything() {
//    when(repositoryMock.getEverything(any())).thenReturn(TestDataUtils.SUCCESS_EVERYTHING_RESPONSE);
////    when(newsRtoService.getEverything(any())).thenReturn(TestDataUtils.SUCCESS_EVERYTHING_RESPONSE);
//
//    EverythingResponse successResponse = service.getEverything(Map.of("query", "bitcoin"));
//
//    assertAll(
//        () -> assertNotNull(successResponse, "The response can't be null"),
//        () -> assertNotNull(successResponse.getArticles(), "The articles can't be null"),
//        () -> assertEquals(TestDataUtils.SUCCESS_OK_RESPONSE, successResponse.getStatus(), "The status isn't correct"),
//        () -> assertEquals(2, successResponse.getArticles().size(), "The size of articles isn't correct")
//    );
//  }
}