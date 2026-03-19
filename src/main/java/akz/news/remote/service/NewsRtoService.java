package akz.news.remote.service;

import akz.news.remote.dto.EverythingResponse;
import akz.news.remote.dto.SourceResponse;
import akz.news.remote.dto.TopHeadlineResponse;
import akz.news.remote.repository.INewsRtoRepository;
import akz.news.utils.Constants;
import akz.news.web.EverythingParamDto;
import akz.news.web.SourceParamDto;
import akz.news.web.TopHeadlineParamDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewsRtoService {

  private static final String NEWS_INSTANCE = "news-instance";
  private final INewsRtoRepository repository;

  @Value("${web-service-news.api.key}")
  private String apiKey;

  @CircuitBreaker(name = NEWS_INSTANCE, fallbackMethod = "failGetEverything")
  public EverythingResponse getEverything(Map<String, String> params) {
    return repository.getEverything(EverythingParamDto.fromMap(params), apiKey, Constants.USER_AGENT_VALUE);
  }

  public EverythingResponse failGetEverything(Map<String, String> params, Throwable ex) {
    log.error("Failed to get everything with params: {}, error: {}", params.toString(), ex.getMessage());
    return EverythingResponse.error(ex.getMessage());
  }

  @CircuitBreaker(name = NEWS_INSTANCE, fallbackMethod = "failGetTopHeadlines")
  public TopHeadlineResponse getTopHeadlines(Map<String, String> params) {
    return repository.getTopHeadlines(TopHeadlineParamDto.fromMap(params), apiKey, Constants.USER_AGENT_VALUE);
  }

  public TopHeadlineResponse failGetTopHeadlines(Map<String, String> params, Throwable ex) {
    log.error("Failed to get top headlines with params: {}, error: {}", params.toString(), ex.getMessage());
    return TopHeadlineResponse.error(ex.getMessage());
  }

  @CircuitBreaker(name = NEWS_INSTANCE, fallbackMethod = "failGetSources")
  public SourceResponse getSources(Map<String, String> params) {
    return repository.getSources(SourceParamDto.fromMap(params), apiKey, Constants.USER_AGENT_VALUE);
  }

  public SourceResponse failGetSources(Map<String, String> params, Throwable ex) {
    log.error("Failed to get sources with params: {}, error: {}", params.toString(), ex.getMessage());
    return SourceResponse.error(ex.getMessage());
  }
}
