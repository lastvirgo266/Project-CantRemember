package remember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("kakao.properties") //���������� ���� ������Ƽ �ҷ�����
public class CantRememberApplication {

	public static void main(String[] args) {
		SpringApplication.run(CantRememberApplication.class, args);
	}

}
