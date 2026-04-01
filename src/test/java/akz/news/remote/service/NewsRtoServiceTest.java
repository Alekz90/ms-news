package akz.news.remote.service;

import akz.news.configuration.FeignConfig;
import akz.news.configuration.RedisConfig;
import akz.news.remote.dto.EverythingResponse;
import akz.news.remote.repository.INewsRtoRepository;
import akz.news.utils.TestDataUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("News Remote Service Test")
@SpringBootTest(classes = { FeignConfig.class})
class NewsRtoServiceTest {

  @MockitoBean
  private INewsRtoRepository repositoryMock;

  @Autowired
  private NewsRtoService newsRtoService;

  @AfterEach
  void tearDown() {
    reset(repositoryMock);
  }

  @Test
  void getEverything() {
    when(repositoryMock.getEverything(any())).thenReturn(TestDataUtils.SUCCESS_EVERYTHING_RESPONSE);

    EverythingResponse successResponse = newsRtoService.getEverything(Map.of("query", "bitcoin"));

    assertAll(
        () -> assertNotNull(successResponse, "The response can't be null"),
        () -> assertNotNull(successResponse.getArticles(), "The articles can't be null"),
        () -> assertEquals(TestDataUtils.SUCCESS_OK_RESPONSE, successResponse.getStatus(), "The status isn't correct"),
        () -> assertEquals(2, successResponse.getArticles().size(), "The size of articles isn't correct")
    );
  }
}