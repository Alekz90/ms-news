package akz.news.remote.dto;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class TopHeadlineResponse extends EverythingResponse {

  public TopHeadlineResponse(int totalResults, List<ArticlesItem> articles, String status, String message) {
    super(totalResults, articles, status, message);
  }

  public static TopHeadlineResponse error(String message) {
    return new TopHeadlineResponse(0, List.of(), "error", message);
  }
}
