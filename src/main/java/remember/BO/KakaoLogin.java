package remember.BO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KakaoLogin {
	
	//@Value("${KAKAO.API.KEY}")
	String API_KEY = "70786c28ac3420bba7084c85209beb27";
	
	String KAKAO_URL = "https://kauth.kakao.com/oauth/authorize?client_id="+API_KEY+"&redirect_uri=http://localhost:8080/login&response_type=code";
	
	public String getURL() {
		System.out.println(API_KEY);
		log.info(API_KEY);
		return KAKAO_URL;
	}
	

}
