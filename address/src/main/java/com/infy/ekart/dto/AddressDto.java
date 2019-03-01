package com.infy.ekart.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.infy.ekart.entity.Address;


public class AddressDto {
	
	private Integer addressId;
	private String address;
	@Pattern(regexp="[a-zA-Z0-9 ]+")
	private String city;
	private String state;
	@Size(min=6,max=6,message="PinCode should be of 6 digits")
	private Long pinCode;
	@Size(min=10,max=10,message="PhoneNumber should be of 10 digits")
	private String phoneNo;
	private String email;
	
	
	public AddressDto() {
		super();
	}
	
	
	public AddressDto(Integer addressId, String address, String city, String state, Long pinCode, String phoneNo, String email) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.phoneNo = phoneNo;
		this.email = email;

	}


	


	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getPinCode() {
		return pinCode;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public Address prepareEntity(AddressDto addressDto)
	{
		Address address = new Address(addressDto.getAddressId(),addressDto.getAddress(),
				addressDto.getCity(), addressDto.getState(),addressDto.getPinCode(),
				addressDto.getPhoneNo(), addressDto.getEmail());
		return address;
		
	}


	public AddressDto prepareEntity(Address address)
	{
		AddressDto addressDto = new AddressDto(address.getAddressId(),address.getAddress(),
				address.getCity(), address.getState(),address.getPinCode(),
				address.getPhoneNo(), address.getEmail());
		return addressDto;
		
	}
	
	

}
