package com.yash.springsecurityokta.service;

import java.util.List;

import com.yash.springsecurityokta.model.Role;

public interface RoleService {
	
	public Role createRole(Role role);
	
	public Role updateRole(Role role);
	
	public List<Role> getAllRole();
	
	public Role getRoleById(Integer roleId);

	public void deleteRole(Integer roleId);

}
