package io.greg.accountapi.controller;

import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.greg.accountapi.entity.Account;
import io.greg.accountapi.service.AccountService;


@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method=RequestMethod.GET, value="/accounts")
	public List<Account> getAllAccounts(){
		
		return accountService.getAllAccounts();
	}

	@RequestMapping(method=RequestMethod.GET, value="/accounts/{id}")
	public Account getAccountById(@PathVariable int id) {
		
		return accountService.getAccount(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/accounts/search")
	public List<Account> findByUsername(@RequestBody String username) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(username);
		String uname = (String)json.get("username");
		
		return accountService.findByUsername(uname);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/accounts", params="username")
	public List<Account> wildcardSearch(@RequestParam String username)  {
		
		String uname = username.replace(' ', '%').toUpperCase()  + "%";
		System.out.println(uname);
		return accountService.wildcardSearch(uname);
	}
	
	
	/* find all accounts given a role_id */
	@RequestMapping(method=RequestMethod.GET, value="/accounts/role/{roleId}")
	public List<Account> getAccountsByRole (@PathVariable int roleId){

		return accountService.getAccountsByRole(roleId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/accounts")
	public void addAccount(@RequestBody Account account) {
		
		accountService.addAccount(account);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/accounts")
	public void updateAccount(@RequestBody Account account) {
		
		accountService.updateAccount(account);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/accounts/{id}")
	public void deleteAccount(@PathVariable int id) {
		
		accountService.deleteAccount(id);
	}
	
	
}
