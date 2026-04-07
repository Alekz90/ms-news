package akz.news.web.service.impl;

import akz.news.exception.CustomException;
import akz.news.remote.dto.AbstractNewsResponse;
import akz.news.remote.dto.EverythingResponse;
import akz.news.remote.dto.SourceResponse;
import akz.news.remote.dto.TopHeadlineResponse;
import akz.news.remote.repository.INewsRtoRepository;
import akz.news.utils.enums.EError;
import akz.news.web.service.INewsService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.data.redis.autoconfigure.DataRedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Map;

import static akz.news.utils.Constants.*;
import static akz.news.utils.TestDataUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles(TEST_PROFILE)
//@Import(TestRedisConfiguration.class)
@DisplayName("News Service Test")
@ImportAutoConfiguration(exclude = { DataRedisAutoConfiguration.class })
class NewsServiceTest {

  @MockitoBean
  private INewsRtoRepository repositoryMock;

  @Autowired
  private INewsService service;

  @BeforeEach
  void setUp() {}

  @AfterEach
  void tearDown() {
    reset(repositoryMock);
  }

  @Test
  @DisplayName("Get all news")
  void getEverything() {
    when(repositoryMock.getEverything(any())).thenReturn(SUCCESS_EVERYTHING_RESPONSE);

    EverythingResponse successResponse = service.getEverything(Map.of("query", "bitcoin"));

    validateCommonAssertions("Success Everything news assertions", successResponse);

    verify(repositoryMock).getEverything(any());
  }

  @Test
  void getTopHeadlines() {
    when(repositoryMock.getTopHeadlines(any())).thenReturn(SUCCESS_TOP_HEADLINES_RESPONSE);

    TopHeadlineResponse successResponse = service.getTopHeadlines(Map.of("country", "US"));

    validateCommonAssertions("Success Top headlines news assertions", successResponse);

    verify(repositoryMock).getTopHeadlines(any());
  }

  @Test
  void getSources() {
    when(repositoryMock.getSources(any())).thenReturn(SUCCESS_SOURCES_RESPONSE);

    SourceResponse successResponse = service.getSources(Map.of("category","business"));

    assertAll("Success Sources assertions",
      () -> assertNotNull(successResponse, "The response can't be null"),
      () -> assertNotNull(successResponse.getSources(), "The sources can't be null"),
      () -> assertEquals(SUCCESS_STATUS_RESPONSE, successResponse.getStatus(), "The status isn't correct"),
      () -> assertEquals(3, successResponse.getSources().size(), "The size of sources isn't correct")
    );

//    when(repositoryMock.getSources(any())).thenThrow(new CustomException(HttpStatus.BAD_REQUEST, EError.TESTING_MESSAGE));
    when(repositoryMock.getSources(any())).thenThrow(new RuntimeException(EError.TESTING_MESSAGE.getMessage()));

    SourceResponse errorResponse = service.getSources(Map.of("category","business"));

    assertAll("Error Sources Assertions",
      () -> assertNotNull(errorResponse, "The response can't be null"),
      () -> assertNotNull(errorResponse.getSources(), "The sources must be null"),
      () -> assertEquals(ERROR_STATUS_RESPONSE, errorResponse.getStatus(), "The status isn't correct"),
      () -> assertEquals(EError.TESTING_MESSAGE.getMessage(), errorResponse.getMessage(), "This message isn't correct")
    );

    verify(repositoryMock, times(2)).getSources(any());
  }

  private void validateCommonAssertions(String heading, AbstractNewsResponse response) {
    assertAll(heading,
      () -> assertNotNull(response, "The response can't be null"),
      () -> assertNotNull(response.getArticles(), "The articles can't be null"),
      () -> assertEquals(SUCCESS_STATUS_RESPONSE, response.getStatus(), "The status isn't correct"),
      () -> assertEquals(2, response.getArticles().size(), "The size of articles isn't correct")
    );
  }
}