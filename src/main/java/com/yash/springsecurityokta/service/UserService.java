package com.yash.springsecurityokta.service; 

import java.util.List;

import com.yash.springsecurityokta.model.User;

public interface UserService {
	
	public User createUser(User user);
	
	public User updateUser(User user);

	public List<User> getAllUser();
	
	public User getUserById(Integer userId);
	
	public void deleteUser(Integer userId);
	
	
}
