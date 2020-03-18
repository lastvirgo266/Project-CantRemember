package remember.service;

import java.util.List;

import remember.entity.GameEntity;

public interface GameService {
	
	//create
	public void createGame(GameEntity game);
	
	//read
	public List<GameEntity> selectGameInfo(int userId, String game);
	
	
	//return gameEntity
	public GameEntity selectGame(int gameId);
	
	
	//update
	public void updateGame(GameEntity game);
	
	//delete
	public void deleteGame(int userId, String game);

}
