package com.infosys.eKart.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.eKart.Domain.Address;
import com.infosys.eKart.Domain.User;
import com.infosys.eKart.Dto.UserDto;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUserIdAndAddresses(Integer userId, Address address);

	User findByEmailAndPassword(String email, String password);
	
}
