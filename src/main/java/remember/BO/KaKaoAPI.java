package remember.BO;

import java.util.List;

import remember.DTO.GameDto;

public interface KakaoAPI {

	public List<String> getAccessToken(String authorize_code);
	
	//게임의 정보를 카카오 API에 저장시킴
	public void SaveGameInfo(String access_Token, GameDto game);
	
	public void logout(String access_Token);
	
	

}
