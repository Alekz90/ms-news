package akz.news.remote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SourceResponse implements Serializable {
	private List<Source> sources;
	private String status;
  private String message;

  public static SourceResponse error(String message) {
    return new SourceResponse(List.of(), "error", message);
  }
}