package akz.news.remote.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractNewsResponse implements Serializable {
  private int totalResults;
  private List<ArticlesItem> articles;
  private String status;
  private String code;
  private String message;
}
