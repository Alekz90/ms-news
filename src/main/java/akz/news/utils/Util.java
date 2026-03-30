package akz.news.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public final class Util {

  public static Map<String, String> buildMapParameters(
      String query, String searchIn, String sources, String domains, String excludeDomains,
      String from, String to, String language, String sortBy, String pageSize, String page
  ) {

    if (StringUtils.isBlank(query) && StringUtils.isBlank(searchIn)
        && StringUtils.isBlank(sources) && StringUtils.isBlank(domains)) {
      throw new IllegalArgumentException("At least one of the following parameters must be provided: query, sources, domains.");
    }

    Map<String, String> params = new HashMap<>();
    if (StringUtils.isNotBlank(searchIn)) params.put("searchIn", searchIn);
    if (StringUtils.isNotBlank(domains)) params.put("domains", domains);
    if (StringUtils.isNotBlank(excludeDomains)) params.put("excludeDomains", excludeDomains);
    if (StringUtils.isNotBlank(from)) params.put("from", from);
    if (StringUtils.isNotBlank(to)) params.put("to", to);
    if (StringUtils.isNotBlank(language)) params.put("language", language);
    if (StringUtils.isNotBlank(sortBy)) params.put("sortBy", sortBy);

    buildMapParameters(params, sources, query, pageSize, page);

    return params;
  }

  public static Map<String, String> buildMapParameters(
      String country, String category, String sources, String query, String pageSize, String page
  ) {

    if (StringUtils.isBlank(country) && StringUtils.isBlank(category)
        && StringUtils.isBlank(sources) && StringUtils.isBlank(query)) {
      throw new IllegalArgumentException("At least one of the following parameters must be provided: country, category, sources, query.");
    }

    Map<String, String> params = new HashMap<>();
    if (StringUtils.isNotBlank(country)) params.put("country", country);
    if (StringUtils.isNotBlank(category)) params.put("category", category);

    buildMapParameters(params, sources, query, pageSize, page);

    return params;
  }

  public static Map<String, String> buildMapParameters(String country, String category, String language) {

    Map<String, String> params = new HashMap<>();
    if (StringUtils.isNotBlank(country)) params.put("country", country);
    if (StringUtils.isNotBlank(category)) params.put("category", category);
    if (StringUtils.isNotBlank(language)) params.put("language", language);

    return params;
  }

  private static void buildMapParameters(
      Map<String, String> params, String sources, String query, String pageSize, String page
  ) {
    if (StringUtils.isNotBlank(sources)) params.put("sources", sources);
    if (StringUtils.isNotBlank(query)) params.put("query", query);
    if (StringUtils.isNotBlank(pageSize)) params.put("pageSize", pageSize);
    if (StringUtils.isNotBlank(page)) params.put("page", page);
  }

  public static Duration getTimeToLive(String timeToLive) {
    String durationType = timeToLive.substring(timeToLive.length() - 1);
    int time = Integer.parseInt(timeToLive.substring(0, timeToLive.length() - 1));
    return switch (durationType) {
      case "d" -> Duration.ofDays(time);
      case "h" -> Duration.ofHours(time);
      case "m" -> Duration.ofMinutes(time);
      default -> Duration.ofSeconds(time);
    };
  }

  private Util() {
    throw new UnsupportedOperationException("Utility class");
  }
}
