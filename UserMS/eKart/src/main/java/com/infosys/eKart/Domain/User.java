package com.infosys.eKart.Domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "users")
//, uniqueConstraints = {
//        @UniqueConstraint(columnNames = "email")
//       
//})
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	private String userName;
	@Column(name = "email",unique = true)
	private String email;
	private String password;
	@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="addressId")
	private List<Address> addresses;
	private Integer userRole; //1-user, 2-seller
	public User() {
		super();
	}

	public User(Integer userId, String userName, String email, String password, List<Address> addresses, Integer userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.addresses = addresses;
		this.userRole = userRole;
	}
    
	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public User(String userName, String email, String password, List<Address> addresses) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.addresses = addresses;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	

	
	
	
	


}
