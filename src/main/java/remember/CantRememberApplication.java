package remember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("kakao.properties") //개인적으로 만든 프로퍼티 불러오기
public class CantRememberApplication {

	public static void main(String[] args) {
		SpringApplication.run(CantRememberApplication.class, args);
	}

}
