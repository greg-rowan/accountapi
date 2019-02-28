package io.greg.accountapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.greg.accountapi.entity.AccountRole;
import io.greg.accountapi.service.AccountRoleService;

@RestController
public class AccountRoleController {

	@Autowired
	private AccountRoleService accountRoleService;
	
	
	@RequestMapping(method=RequestMethod.GET, value="/accountroles")
	public List<AccountRole> getAllAccountRoles(){
		
		return accountRoleService.getAllAccountRoles();
	}

	
	@RequestMapping(method=RequestMethod.POST, value="/accountroles")
	public void addAccountRole(@RequestBody AccountRole acctRole) {
		
		accountRoleService.addAccountRole(acctRole);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/accountroles")
	public void updateAccountRole(@RequestBody AccountRole acctRole) {
		
		accountRoleService.updateAccountRole(acctRole);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/accountroles/{id}")
	public void deleteAccountRole(@PathVariable int id) {
		
		accountRoleService.deleteAccountRole(id);
	}
	
}
