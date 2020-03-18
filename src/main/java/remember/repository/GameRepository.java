package remember.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import remember.entity.GameEntity;


@Repository
public interface GameRepository extends CrudRepository<GameEntity, Integer> {
	List<GameEntity> findAllByUserIdAndGame(int userId, String game);
	void deleteByuserIdAndGame(int userId, String game);

}
