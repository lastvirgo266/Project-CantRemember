package remember.BO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


@PropertySource(value = "classpath:application.properties")
public class KaKaoAPI {
	
	@Value("${KAKAO_API_KEY}")
	static String API_KEY;
	static String KAKAO_URL = "kauth.kakao.com/oauth/authorize?client_id="+API_KEY+"&redirect_uri=http://localhost:8000/login&response_type=code";
	
	

}
