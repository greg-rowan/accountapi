package io.greg.accountapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.greg.accountapi.entity.AccountRole;
import io.greg.accountapi.repository.AccountRoleRepository;

@Service
public class AccountRoleService {

	@Autowired
	AccountRoleRepository accountRoleRepository;
	
	public List<AccountRole> getAllAccountRoles(){
		
		
		try {
			return this.accountRoleRepository.findAll();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		
	}
	
	public void addAccountRole(AccountRole acctRole)
	{
		accountRoleRepository.save(acctRole);
	}	

	public void updateAccountRole(AccountRole acctRole) {
		accountRoleRepository.save(acctRole);
	}
	
	public void deleteAccountRole(int id) {
		accountRoleRepository.deleteById(id);
	}
	
}
