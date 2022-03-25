package com.yash.springsecurityokta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.springsecurityokta.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
