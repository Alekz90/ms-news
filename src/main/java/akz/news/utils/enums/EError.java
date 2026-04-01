package akz.news.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EError {

  GENERAL_MESSAGE             ("0001", "An error has been happened during the process."),
  UTILITY_CLASS               ("0002", "This class isn't allowed to create any instances."),
  BAD_REQUEST                 ("0003", "An error occurred while processing the request."),
  RESOURCE_NOT_FOUND          ("0004", "The resource wasn't found."),
  REQUIRED_PARAM_EVERYTHING   ("0005", "At least one of the following parameters must be provided: query, sources, domains."),
  REQUIRED_PARAM_TOP_HEADLINE ("0006", "At least one of the following parameters must be provided: query, sources, country, category.");

  private final String id;
  private final String message;

}
