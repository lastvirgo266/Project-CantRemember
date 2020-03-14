package remember.BO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaoAPI {

	@Value("${KAKAO.API.KEY}")
	String API_KEY;
	
	public String getAccessToken(String authorize_code) {
		
		
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";
		
		try {
			URL url = new URL(reqURL);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			
			//POST config
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			//parameter Stream sending
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id="+API_KEY);
			sb.append("&redirect_uri=http://localhost:8080/login");
			sb.append("&code="+authorize_code);
			bw.write(sb.toString());
			bw.flush();
			
			int responseCode = conn.getResponseCode();
			log.info("responose : "+responseCode);
			
	           //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";
            
            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);
            
            
            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);
            
            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
            
            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);
            
            br.close();
            bw.close();
			
		} catch(IOException e) {
			e.printStackTrace();	
		}
		
		return access_Token;
		
	}
	
	
	//유저의 정보를 카카오 API에 저장시킴
	public void SaveUserInfo(String access_Token) {

		try {
			String reqURL = "https://kapi.kakao.com/v1/user/update_profile";
		
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("game", "diablow");
		
			ObjectMapper JACKSON_OBJECT_MAPPER = new ObjectMapper();
		
			String param = "properties="+JACKSON_OBJECT_MAPPER.writeValueAsString(map);
			
			URL url = new URL(reqURL);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			
			
			
			//POST config
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			//HeaderConfig
			conn.setRequestProperty("Authorization", "Bearer "+ access_Token);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			
			//parameter Stream sending
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
			writer.write(param);
			writer.flush();
			
			int responseCode = conn.getResponseCode();
			log.info("responose : "+responseCode);
			
	        //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";
            
            while ((line = br.readLine()) != null) {
                result += line;
            }
 
            
            br.close();
            writer.close();
			
		} catch(IOException e) {
			e.printStackTrace();	
		}
	}
	
	

}
