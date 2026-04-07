package akz.news.remote.dto;

import akz.news.utils.Constants;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

public class EverythingResponse extends AbstractNewsResponse {

  @Builder
  public EverythingResponse(int totalResults, List<ArticlesItem> articles, String status, String code, String message) {
    super(totalResults, articles, status, code, message);
  }

  public static EverythingResponse error(String message) {
    return EverythingResponse.builder()
      .totalResults(0)
      .status(Constants.ERROR_STATUS_RESPONSE)
      .message(message)
      .articles(new ArrayList<>())
      .build();
  }
}