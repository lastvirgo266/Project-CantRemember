package remember.BO;

import java.util.List;

import remember.DTO.GameDto;

public interface KakaoAPI {

	public List<String> getAccessToken(String authorize_code);
	
	//������ ������ īī�� API�� �����Ŵ
	public void SaveGameInfo(String access_Token, GameDto game);
	
	public void logout(String access_Token);
	
	

}
