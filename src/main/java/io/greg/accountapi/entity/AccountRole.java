package io.greg.accountapi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="account_role") 
@Table(name="account_role")
public class AccountRole { 
	
	@EmbeddedId
	private AccountRoleId acctRoleId;
	
	public AccountRoleId getAcctRoleId() {
		return acctRoleId;
	}

	public void setAcctRoleId(AccountRoleId acctRoleId) {
		this.acctRoleId = acctRoleId;
	}
	
	@Embeddable
	public static class AccountRoleId implements Serializable{

		private static final long serialVersionUID = 7926335229398722415L;

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public int getRole_id() {
			return role_id;
		}

		public void setRole_id(int role_id) {
			this.role_id = role_id;
		}

		private int user_id;
		private int role_id;		
	}
	
	public Timestamp getGrant_date() {
		return grant_date;
	}

	public void setGrant_date(Timestamp grant_date) {
		this.grant_date = grant_date;
	}	
	
	private Timestamp grant_date;
}
