package com.yash.springsecurityokta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.springsecurityokta.exception.RoleNotFoundException;
import com.yash.springsecurityokta.model.Role;
import com.yash.springsecurityokta.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		
		Optional<Role> roleDb = this.roleRepository.findById(role.getRoleId());
		
		if(roleDb.isPresent()) {
			Role roleUpdate = roleDb.get();
			roleUpdate.setRoleId(role.getRoleId());
			roleUpdate.setRoleName(role.getRoleName());
			
			roleRepository.save(roleUpdate);
			return roleUpdate;
		}else {
			throw new RoleNotFoundException("role not found : "+ role.getRoleId());
		}
	}

	@Override
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleById(Integer roleId) {
		Optional<Role> roleDb = roleRepository.findById(roleId);
		
		if(roleDb.isPresent()) {
			return roleDb.get();
		}else {
			throw new RoleNotFoundException("role not found : "+ roleId);
		}
	}

	@Override
	public void deleteRole(Integer roleId) {
		
		Optional<Role> roleDb = roleRepository.findById(roleId);
		
		if(roleDb.isPresent()) {
			roleRepository.delete(roleDb.get());
		}else {
			throw new RoleNotFoundException("role not found : "+ roleId);
		}
		
	}

}
