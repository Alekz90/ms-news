package akz.news.configuration;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FeignConfig {

  public static final String X_API_KEY_HEADER = "X-Api-Key";
  public static final String USER_AGENT_HEADER_NAME = "User-Agent";
  public static final String USER_AGENT_HEADER_VALUE = "NewsApp/1.0 (alejdaf@outlook.com)";

  @Value("${web-service-news.api.key}")
  private String apiKey;

  @Bean
  RequestInterceptor requestInterceptor() {
    return requestTemplate ->
      requestTemplate
          .header(X_API_KEY_HEADER, apiKey)
          .header(USER_AGENT_HEADER_NAME, USER_AGENT_HEADER_VALUE);
  }
}
