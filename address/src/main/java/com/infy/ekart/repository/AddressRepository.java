package com.infy.ekart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.ekart.entity.Address;



@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {


	List<Address> findByState(String email);

	//Address findByAddressIdAndUser(Integer addressId);

	//Optional<Address> findById(Integer addressId);

}
