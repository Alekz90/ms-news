package akz.news.web.controller;

import akz.news.remote.dto.EverythingResponse;
import akz.news.remote.dto.SourceResponse;
import akz.news.remote.dto.TopHeadlineResponse;
import akz.news.utils.DocumentationConstants;
import akz.news.utils.Util;
import akz.news.web.service.INewsService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
@Tag(name = "NewsController", description = "Controller for fetching news articles based on various parameters")
@RequiredArgsConstructor
public class NewsController {

  private final INewsService service;


  @GetMapping("/everything")
  public ResponseEntity<EverythingResponse> getEverything(
      @Schema(example = "bitcoin", description = DocumentationConstants.QUERY_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String query,
      @Schema(example = "crypto", description = DocumentationConstants.SEARCH_IN_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String searchIn,
      @Schema(example = "hk", description = DocumentationConstants.SOURCES_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String sources,
      @Schema(example = "techcrunch.com,thenextweb.com", description = DocumentationConstants.DOMAINS_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String domains,
      @Schema(example = "thenextweb.com", description = DocumentationConstants.EXCLUDE_DOMAINS_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String excludeDomains,
      @Schema(example = "2026-03-10", description = DocumentationConstants.FROM_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String from,
      @Schema(example = "2026-03-18", description = DocumentationConstants.TO_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String to,
      @Schema(example = "fr", description = DocumentationConstants.LANGUAGE_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String language,
      @Schema(example = "publishedAt", description = DocumentationConstants.SORT_BY_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String sortBy,
      @Schema(example = "100", description = DocumentationConstants.PAGE_SIZE_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String pageSize,
      @Schema(example = "1", description = DocumentationConstants.PAGE_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String page
  ) {
    return ResponseEntity.ok(service.getEverything(Util.buildMapParameters(
        query, searchIn, sources, domains, excludeDomains, from, to, language, sortBy, pageSize, page)));
  }

  @GetMapping("/top-headlines")
  public ResponseEntity<TopHeadlineResponse> getTopHeadlines(
      @Schema(example = "bitcoin", description = DocumentationConstants.QUERY_TOP_HEADLINES_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String query,
      @Schema(example = "hk", description = DocumentationConstants.SOURCES_TOP_HEADLINES_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String sources,
      @Schema(example = "us", description = DocumentationConstants.COUNTRY_TOP_HEADLINES_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String country,
      @Schema(example = "business", description = DocumentationConstants.CATEGORY_TOP_HEADLINES_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String category,
      @Schema(example = "100", description = DocumentationConstants.PAGE_SIZE_TOP_HEADLINES_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String pageSize,
      @Schema(example = "1", description = DocumentationConstants.PAGE_TOP_HEADLINES_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String page
  ) {
    return ResponseEntity.ok(service.getTopHeadlines(
        Util.buildMapParameters(query, sources, country, category, pageSize, page)));
  }

  @GetMapping("top-headlines/source")
  public ResponseEntity<SourceResponse> getSources(
      @Schema(example = "entertainment", description = DocumentationConstants.CATEGORY_SOURCE_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String category,
      @Schema(example = "it", description = DocumentationConstants.LANGUAGE_SOURCE_HEADLINES_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String language,
      @Schema(example = "mx", description = DocumentationConstants.COUNTRY_SOURCE_HEADLINES_PARAMETER_DESCRIPTION)
      @RequestParam(required = false) String country
  ) {
    return ResponseEntity.ok(service.getSources(Util.buildMapParameters(country, category, language)));
  }
}
