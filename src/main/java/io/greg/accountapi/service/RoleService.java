package io.greg.accountapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.greg.accountapi.entity.Role;
import io.greg.accountapi.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> getAllRoles(){
		
		return this.roleRepository.findAll();
	}

	public Role getRole(int id) {
		
		List<Role> roles = getAllRoles();
		Role role = roles.stream()
				.filter(r -> r.getRole_id() == id)
				.findFirst()
				.orElse(null);
		return role;
	}
	
	
	public void addRole(Role role) {
		
		roleRepository.save(role);
	}
	
	public void updateRole(Role role) {
		
		roleRepository.save(role);
	}
	

	public void deleteRole(int id) {
		
		roleRepository.deleteById(id);
	}	
	
}
