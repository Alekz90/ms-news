package akz.news.remote.repository;

import akz.news.remote.dto.EverythingResponse;
import akz.news.remote.dto.SourceResponse;
import akz.news.remote.dto.TopHeadlineResponse;
import akz.news.utils.Constants;
import akz.news.web.EverythingParamDto;
import akz.news.web.SourceParamDto;
import akz.news.web.TopHeadlineParamDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@Repository
@FeignClient(name = "news-web-service", url = "${web-service-news.api.base-url}")
public interface INewsRtoRepository {

  @GetMapping("/everything")
  EverythingResponse getEverything(@SpringQueryMap EverythingParamDto params,
                                   @RequestHeader(Constants.X_API_KEY_HEADER) String apiKey,
                                   @RequestHeader(Constants.USER_AGENT) String userAgent);

  @GetMapping("/top-headlines")
  TopHeadlineResponse getTopHeadlines(@SpringQueryMap TopHeadlineParamDto params,
                                      @RequestHeader(Constants.X_API_KEY_HEADER) String apiKey,
                                      @RequestHeader(Constants.USER_AGENT) String userAgent);

  @GetMapping("/top-headlines/sources")
  SourceResponse getSources(@SpringQueryMap SourceParamDto params,
                            @RequestHeader(Constants.X_API_KEY_HEADER) String apiKey,
                            @RequestHeader(Constants.USER_AGENT) String userAgent);
}
