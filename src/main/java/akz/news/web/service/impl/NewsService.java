package akz.news.web.service.impl;

import akz.news.remote.dto.EverythingResponse;
import akz.news.remote.dto.SourceResponse;
import akz.news.remote.dto.TopHeadlineResponse;
import akz.news.remote.service.NewsRtoService;
import akz.news.web.service.INewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class NewsService implements INewsService {

  private final NewsRtoService newsRtoService;

  @Override
  public EverythingResponse getEverything(Map<String, String> params) {
    return newsRtoService.getEverything(params);
  }

  @Override
  public TopHeadlineResponse getTopHeadlines(Map<String, String> params) {
    return newsRtoService.getTopHeadlines(params);
  }

  @Override
  public SourceResponse getSources(Map<String, String> params) {
    return newsRtoService.getSources(params);
  }
}
