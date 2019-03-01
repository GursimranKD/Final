package com.infy.ekart.service;


import java.util.List;

import com.infy.ekart.entity.Address;
import com.infy.ekart.exceptions.NoEntriesFound;
import com.infy.ekart.exceptions.UserNotAllowedException;
import com.infy.ekart.dto.AddressDto;

public interface AddressService {
	//public User getUser();
	public void addAddress(String email,AddressDto address);




	List<Address> getAddress(String email) throws NoEntriesFound;



	boolean modifyAddress(String email, Integer addressId, AddressDto addressDto) throws UserNotAllowedException;





	boolean deleteAddress(String email, Integer addressId) throws UserNotAllowedException, Exception;

}
