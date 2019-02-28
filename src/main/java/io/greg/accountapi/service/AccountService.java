package io.greg.accountapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.greg.accountapi.entity.Account;
import io.greg.accountapi.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> getAllAccounts(){
		
		return this.accountRepository.findAll();
	}

	public List<Account> getAccountsByRole(int roleId){
		
		List<Account> acctList = getAllAccounts();
		
		return acctList.stream()
				.filter(a -> a.getRole().getRole_id() == roleId)
				.collect(Collectors.toList());

	}
	
	public List<Account> findByUsername(String username) {
		return this.accountRepository.findByusername(username);
	}
	
	public Account getAccount(int id) {
		
		List<Account> accts = getAllAccounts();
		Account acct = accts.stream()
				.filter(a -> a.getUser_id() == id)
				.findFirst()
				.orElse(null);
		return acct;
	}
	
	public List<Account> wildcardSearch(String username){
		
		return this.accountRepository.wildcardSearch(username);
	}
	
	public void addAccount(Account account) {
		
		accountRepository.save(account);
	}
	
	public void updateAccount(Account account) {
		
		accountRepository.save(account);
	}
	

	public void deleteAccount(int id) {
		
		accountRepository.deleteById(id);
	}
	
}
