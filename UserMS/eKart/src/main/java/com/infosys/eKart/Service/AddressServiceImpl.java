package com.infosys.eKart.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.eKart.Domain.Address;
import com.infosys.eKart.Domain.User;
import com.infosys.eKart.Dto.AddressDto;
import com.infosys.eKart.Repository.AddressRepository;
import com.infosys.eKart.Repository.UserRepository;


@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	 AddressRepository addressRepository;
	@Autowired
	 UserRepository userRepository;

	@Override
	public void addAddress(Integer id,AddressDto addressDto) {
		Address address = new Address();
		address= addressDto.prepareEntity(addressDto);
		User user = new  User();
		user=userRepository.findById(id).get();
		List<Address> list1 = new ArrayList<>();
		list1=user.getAddresses();
		list1.add(address);
		user.setAddresses(list1);
		System.out.println(list1.size());
		//addressRepository.save(address);
		userRepository.save(user);
		
	}
	
	@Override
	@Transactional
    @Modifying(clearAutomatically=true)
	public boolean modifyAddress(Integer id,Integer addressId,AddressDto addressDto) {
//		User user = new  User();
//		user=userRepository.findById(id).get();
		//addressDto.setUser(user);
		Address address = addressRepository.findById(addressId).get();
		
		User user= userRepository.findByUserIdAndAddresses(id,address);
		
		if(user!=null)
		{
			//addressDto.setAddressId(address.getAddressId());
			//address.setAddress(addressDto.getAddress());
			Address add = new Address(addressDto.getAddress(),addressDto.getCity(),
					addressDto.getState(),addressDto.getPinCode(), addressDto.getPhoneNo());
			add.setAddressId(address.getAddressId());
//			Address address1= user.getAddresses().get(0);
//			address1= addressDto.prepareEntity(addressDto);
			
			List<Address> list1 = new ArrayList<>() ;
			list1.add(add);
//			address.setUser(user);
			user.setAddresses(list1);
			//addressRepository.save(address);
			userRepository.save(user);
			return true;
		}
		return false;
		
	}
	

	@Override
	@Transactional
    @Modifying(clearAutomatically=true)
	public boolean deleteAddress(Integer id,Integer addressId) {
		User user = new  User();
		user=userRepository.findById(id).get();
        Address address = addressRepository.findById(addressId).get();
        
		if(address!=null)
		{
			List<Address> list1 = new ArrayList<>();
			list1=user.getAddresses();
			list1.remove(address);
			userRepository.save(user);
			
			//addressRepository.delete(address);
			return true;
		}
		return false;
		
	}
	
	
    

	
	@Override
	public 	List<Address> getAddress(Integer id) {
		User user = new  User();
		user=userRepository.findById(id).get();
		List<Address> list1=user.getAddresses();
		
		System.out.println("size"+list1.size());
		return list1;
	}

}
