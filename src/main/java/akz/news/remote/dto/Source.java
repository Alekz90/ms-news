package akz.news.remote.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Source{
	private String name;
	private String id;
  private String country;
  private String description;
  private String language;
  private String category;
  private String url;
}