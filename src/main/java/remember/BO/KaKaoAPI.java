package remember.BO;

import java.util.List;

import remember.DTO.GameDto;
import remember.entity.GameEntity;

public interface KakaoAPI {

	public List<String> getAccessToken(String authorize_code);
	
	//������ ������ īī�� API�� �����Ŵ
	public void SaveGameInfoToKakao(String access_Token, GameDto game);
	
	public void logout(String access_Token);
	
	public String getId(String access_Token);
	
	public void saveGameInfoJpa(GameEntity game);
	
	

}
