package remember.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import remember.entity.GameEntity;


@Repository
public interface GameRepository extends CrudRepository<GameEntity, Integer> {
	

}
