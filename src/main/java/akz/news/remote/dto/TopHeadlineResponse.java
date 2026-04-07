package akz.news.remote.dto;

import akz.news.utils.Constants;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class TopHeadlineResponse extends AbstractNewsResponse {

  @Builder
  public TopHeadlineResponse(int totalResults, List<ArticlesItem> articles, String status, String code, String message) {
    super(totalResults, articles, status, code, message);
  }

  public static TopHeadlineResponse error(String message) {
    return TopHeadlineResponse.builder()
      .status(Constants.ERROR_STATUS_RESPONSE)
      .message(message)
      .build();
  }
}
