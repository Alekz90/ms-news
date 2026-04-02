package akz.news.configuration;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static akz.news.utils.Constants.NOT_TEST_PROFILE;

@Configuration
@Profile(NOT_TEST_PROFILE)
public class FeignConfiguration {

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
