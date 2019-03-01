package com.infosys.eKart.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.eKart.Domain.Address;
import com.infosys.eKart.Domain.User;



@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

	//Address findByAddressIdAndUser(Integer addressId);

	//Optional<Address> findById(Integer addressId);

}
