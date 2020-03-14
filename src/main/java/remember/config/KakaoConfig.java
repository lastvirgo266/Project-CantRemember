package remember.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:kakao.properties")
@Configuration
public class KakaoConfig {
	
	@Value("${KAKAO.API.KEY}")
	static String API_KEY;

}
