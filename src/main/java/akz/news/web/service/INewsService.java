package akz.news.web.service;

import akz.news.remote.dto.EverythingResponse;
import akz.news.remote.dto.SourceResponse;
import akz.news.remote.dto.TopHeadlineResponse;

import java.util.Map;

public interface INewsService {
  EverythingResponse getEverything(Map<String, String> params);
  TopHeadlineResponse getTopHeadlines(Map<String, String> params);
  SourceResponse getSources(Map<String, String> params);
}
