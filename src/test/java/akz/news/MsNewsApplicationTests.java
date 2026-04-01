package akz.news;

import akz.news.configuration.FeignConfig;
import akz.news.configuration.RedisConfig;
import akz.news.remote.service.NewsRtoService;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.Mockito.mockStatic;

@SpringBootTest//(classes = { FeignConfig.class, RedisConfig.class })
class MsNewsApplicationTests {

  @MockitoBean
  FeignConfig FeignConfig;

	@Test
	void contextLoads() {
    try (MockedStatic<SpringApplication> mockedSpringApplication = mockStatic(SpringApplication.class)) {
      String[] args = {};
      MsNewsApplication.main(args);
      mockedSpringApplication.verify(() -> SpringApplication.run(MsNewsApplication.class, args));
    }
	}

}
