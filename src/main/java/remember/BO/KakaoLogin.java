package remember.BO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaoLogin {
	
	@Value("${KAKAO.API.KEY}")
	String API_KEY;
	
	
	public String getURL() {
		System.out.println(API_KEY);
		log.info(API_KEY);
		String KAKAO_URL = "https://kauth.kakao.com/oauth/authorize?client_id="+API_KEY+"&redirect_uri=http://localhost:8080/login&response_type=code";
		return KAKAO_URL;
	}
	

}
