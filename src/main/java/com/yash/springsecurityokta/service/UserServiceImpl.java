package com.yash.springsecurityokta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.springsecurityokta.exception.UserNotFoundException;
import com.yash.springsecurityokta.model.User;
import com.yash.springsecurityokta.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		Optional<User> userDb = userRepository.findById(user.getUserId());
		
		if(userDb.isPresent()) {
			User userUpdate = userDb.get();
			userUpdate.setUserId(user.getUserId());
			userUpdate.setUserName(user.getUserName());
		//	userUpdate.setPassword(user.getPassword());
			userUpdate.setRole(user.getRole());
			
			userRepository.save(userUpdate);
			
			return userUpdate;
			
		}else {
			throw new UserNotFoundException("User not found : "+ user.getUserId());
		}
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer userId) {
		
		Optional<User> userDb = userRepository.findById(userId); 
		
		if(userDb.isPresent()) {
			return userDb.get();
		}else {
			throw new UserNotFoundException("user not found : " + userId);
		}	
	}

	@Override
	public void deleteUser(Integer userId) {
		
		Optional<User> userDb = userRepository.findById(userId);
		
		if (userDb.isPresent()) {
			userRepository.delete(userDb.get());
		}else {
			throw new UserNotFoundException("user not found : " + userId);
		}
		
	}

	
}
