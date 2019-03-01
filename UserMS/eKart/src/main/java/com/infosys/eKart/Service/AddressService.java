package com.infosys.eKart.Service;


import java.util.List;

import com.infosys.eKart.Domain.Address;
import com.infosys.eKart.Dto.AddressDto;

public interface AddressService {
	//public User getUser();
	public void addAddress(Integer id,AddressDto address);

     

	List<Address> getAddress(Integer id);



	boolean modifyAddress(Integer id, Integer addressId, AddressDto addressDto);



	boolean deleteAddress(Integer id, Integer addressId);

}
