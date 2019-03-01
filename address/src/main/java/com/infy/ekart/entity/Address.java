package com.infy.ekart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer addressId;
	private String address;
	private String city;
	private String state;
	private Long pinCode;
	private String phoneNo;
	private String email;
	
	
	public Address() {
		super();
	}
	
	
	
	public Address(String address, String city, String state, Long pinCode, String phoneNo, String email) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.phoneNo = phoneNo;
		this.email = email;
	}



	public Address(Integer addressId, String address, String city, String state, Long pinCode, String phoneNo, String email) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.phoneNo = phoneNo;
		this.email = email;

	}
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
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



	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", pinCode=" + pinCode + ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}
	
	
	
	
}
