package remember.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import remember.entity.GameEntity;
import remember.entity.UserEntity;
import remember.repository.GameRepository;
import remember.repository.UserRepository;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	GameRepository gameRepository;
	
	@Override
	public void createGame(GameEntity game) {
		gameRepository.save(game);
	}
	
	
	@Override
	public List<GameEntity> selectGameInfo(int userId, String game){
		return gameRepository.findAllUserIdAndGame(userId, game);
	}
	
	@Override
	public GameEntity selectGame(int gameId) {
		Optional <GameEntity> optional = gameRepository.findById(gameId);
		
		if(optional.isPresent())
			return optional.get();
		else
			throw new NullPointerException();
	}
	
	
	@Override
	public void updateGame(GameEntity game) {
		gameRepository.save(game);
	}
	
	
	@Override
	public void deleteGame(int gameId) {
		gameRepository.deleteById(gameId);
	}

}
