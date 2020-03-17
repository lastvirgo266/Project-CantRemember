package remember.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import remember.entity.UserEntity;
import remember.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void createUser(UserEntity user) {
		userRepository.save(user);
	}
	
	
	@Override
	public UserEntity selectUser(int userId) {
		Optional <UserEntity> optional = userRepository.findById(userId);
		
		if(optional.isPresent())
			return optional.get();
		else
			throw new NullPointerException();
	}
	
	
	@Override
	public void updateUser(UserEntity user) {
		userRepository.save(user);
	}
	
	
	@Override
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}
	
	

}
