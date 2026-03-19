package akz.news.remote.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EverythingResponse implements Serializable {
	protected int totalResults;
	protected List<ArticlesItem> articles;
	protected String status;
  protected String message;

  public static EverythingResponse error(String message) {
    return new EverythingResponse(0, List.of(), "error", message);
  }
}