package io.greg.accountapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.greg.accountapi.entity.Role;
import io.greg.accountapi.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method=RequestMethod.GET, value="/roles")
	public List<Role> getAllRoles(){
		
		return roleService.getAllRoles();
	}

	@RequestMapping(method=RequestMethod.GET, value="/roles/{id}")
	public Role getRoleById(@PathVariable int id) {
		
		return roleService.getRole(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/roles")
	public void addRole(@RequestBody Role role) {
		
		roleService.addRole(role);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/roles")
	public void updateRole(@RequestBody Role role) {
		
		roleService.updateRole(role);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/roles/{id}")
	public void deleteRole(@PathVariable int id) {
		
		roleService.deleteRole(id);
	}	
	
	
}
