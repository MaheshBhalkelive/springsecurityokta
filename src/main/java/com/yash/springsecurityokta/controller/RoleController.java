package com.yash.springsecurityokta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.springsecurityokta.model.Role;
import com.yash.springsecurityokta.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/getallrole")
	public ResponseEntity<List<Role>> getAllRole(){
		return ResponseEntity.ok().body(this.roleService.getAllRole());
	}
	
	@PostMapping("/createrole")
	public ResponseEntity<Role> creteRole(@RequestBody Role role){
		return ResponseEntity.status(201).body(this.roleService.createRole(role));
	}
	
	@GetMapping("/getrolebyid/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable Integer id){
		return ResponseEntity.status(200).body(this.roleService.getRoleById(id));
	}
	
	@PutMapping("/updaterole/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable Integer id, @RequestBody Role role){
		role.setRoleId(id);
		return ResponseEntity.status(202).body(this.roleService.updateRole(role));
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus deleteRole(@PathVariable Integer id){
		roleService.deleteRole(id);
		return HttpStatus.OK;
	}
	
}
