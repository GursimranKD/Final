package com.infosys.eKart.Dto;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.UniqueElements;

import com.infosys.eKart.Domain.Address;
import com.infosys.eKart.Domain.User;

public class UserDto {
	
	
	private Integer userId;
	@NotNull(message = "userName value is required")
	@Pattern(regexp = "[a-zA-Z]+[\\sa-zA-Z]*",message="userName should not contain any special characters except space")
	private String userName;
	//@UniqueElements(message = "Email already in use")
	
	@Column(unique = true)
	@NotNull(message = "Email value is required")
	@Email(message="Invalid email")
	private String email;
	
	@NotNull(message = "Password value is required")
	@Pattern(regexp = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,})",message="Password must contain one Uppercase,one Lowercase and one special characters ")
	private String password;
	private List<Address> addresses;
	private Integer userRole;
	
	public UserDto() {
		super();
	}

	public UserDto(Integer userId, String userName, String email, String password, List<Address> addresses, Integer userRole) {
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

	public User prepareEntity(UserDto userDto)
	{
		User user = new User(userDto.getUserId(), 
				userDto.getUserName(),userDto.getEmail(), userDto.getPassword(),userDto.getAddresses(), userDto.getUserRole());
		return user;
		
	}
	
	public UserDto prepareDto(User user) {
		UserDto userDto= new UserDto(user.getUserId(), 
				user.getUserName(),user.getEmail(), user.getPassword(),user.getAddresses(), user.getUserRole());
	
		return userDto;
		
	}
}
