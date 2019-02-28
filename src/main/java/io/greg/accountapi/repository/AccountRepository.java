package io.greg.accountapi.repository;

import io.greg.accountapi.entity.Account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer > {

	List<Account> findByusername(String username);
	
	@Query("select a from account a where upper(username) like ?1")
	List<Account> wildcardSearch(String username);
	
	
}
