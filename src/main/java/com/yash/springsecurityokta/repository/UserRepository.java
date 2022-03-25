package com.yash.springsecurityokta.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yash.springsecurityokta.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "select user_name from user where user_name=:d", nativeQuery = true )
	public String findByUserName(@Param ("d") String userName);

}
