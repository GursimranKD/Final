package com.infy.ekart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.ekart.entity.Address;
import com.infy.ekart.exceptions.NoEntriesFound;
import com.infy.ekart.exceptions.UserNotAllowedException;
import com.infy.ekart.dto.AddressDto;
import com.infy.ekart.repository.AddressRepository;


@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	 AddressRepository addressRepository;


	@Override
	public void addAddress(String email,AddressDto addressDto) {
		
		Address address = new Address();
		address= addressDto.prepareEntity(addressDto);
		address.setEmail(email);
//		List<Address> list1 = new ArrayList<>();
//		list1=addressRepository.getAddressByEmail(addressDto.getEmail());
//		list1.add(address);
		addressRepository.save(address);
		
	}
	
	@Override
	@Transactional
    @Modifying(clearAutomatically=true)
	public boolean modifyAddress(String email,Integer addressId,AddressDto addressDto) throws UserNotAllowedException {
//		User user = new  User();
//		user=userRepository.findById(id).get();
		//addressDto.setUser(user);
		Address address = addressRepository.findById(addressId).get();
		
		if(address!=null)
		{
			if(address.getEmail()==email) {
			//addressDto.setAddressId(address.getAddressId());
			//address.setAddress(addressDto.getAddress());
			address.setAddress(addressDto.getAddress());
			address.setCity(addressDto.getCity());
			address.setPhoneNo(addressDto.getPhoneNo());
			address.setState(addressDto.getState());
			address.setPinCode(addressDto.getPinCode());
			address.setEmail(addressDto.getEmail());
			addressRepository.saveAndFlush(address);
//			Address address1= user.getAddresses().get(0);
//			address1= addressDto.prepareEntity(addressDto);
			
			return true;
			}
			else {
				throw new UserNotAllowedException("User does not own this address");
 
			}
		}
		return false;
		
	}
	

	@Override
	@Transactional
    @Modifying(clearAutomatically=true)
	public boolean deleteAddress(String email,Integer addressId) throws UserNotAllowedException,Exception {
	
        Address address = addressRepository.findById(addressId).get();
        
		if(address!=null)
		{
			if(address.getEmail()==email) {
			addressRepository.delete(address);
			return true;
			}
			else {
				throw new UserNotAllowedException("User does not own this address");
			}
		}
		else {
			throw new Exception("Address doesnot exist");
		}
		
	}
	
	
    

	
	@Override
	public 	List<Address> getAddress(String email) throws NoEntriesFound {

		List<Address> list1 = new ArrayList<>();
		list1=addressRepository.findByState(email);
		System.out.println(list1.isEmpty());
//		for(int i=0;i<list1.size();i++) {
//			System.out.println(list1.get(i));
//		}
		
		if(list1.isEmpty()) {
			throw new NoEntriesFound("No addresses for entry");
		}
		System.out.println(addressRepository.count());
		return list1;
	}

}
