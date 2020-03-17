package remember.service;

import remember.entity.UserEntity;

public interface UserService {
	
	//Create
	public void createUser(UserEntity user);
	
	//Read
	public UserEntity selectUser(int userId);
	
	//update
	public void updateUser(UserEntity user);
	
	//delete
	public void deleteUser(int userId);


}
