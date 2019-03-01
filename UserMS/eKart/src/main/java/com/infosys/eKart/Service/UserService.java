package com.infosys.eKart.Service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.eKart.Domain.Address;
import com.infosys.eKart.Domain.User;
import com.infosys.eKart.Dto.UserDto;
import com.infosys.eKart.Repository.UserRepository;

@Service
public class UserService implements UserServ {

	
	@Autowired
	 UserRepository userRepository;
	
	@Override
	public User getUser() {
		Address add1= new Address(1, "home", "bn", "kn", 800006L, "9999999999");
		List<Address> list1 = new ArrayList<>();
		list1.add(add1);
		User user1=new User(101, "anuva", "anuva@infosys.com", "hello",list1,1);
		
		return user1;
	}

	
	@Override
	public void addCust(UserDto userDto) throws Exception {
		try {
			User user = new User(userDto.getUserId(), userDto.getUserName(), userDto.getEmail(),
					userDto.getPassword(), userDto.getAddresses(),1);
			userRepository.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unique constraint or index violation");
		}
		
		
	}

	
	@Override
	public void modifyCust(@Valid UserDto userDto, Integer userid) {
		User user = userRepository.findById(userid).get();
		
		if(user!=null) {
			User user1= new User(userDto.getUserName(),userDto.getEmail(),
					userDto.getPassword(), userDto.getAddresses());
			user1.setUserId(user.getUserId());
			userRepository.save(user1);
		}
		
	}


	@Override
	public UserDto loginCheck(UserDto userDto) {
		User user = userRepository.findByEmailAndPassword( userDto.getEmail(),userDto.getPassword());
		if(user==null) return null;
		return new UserDto().prepareDto(user);
	}

}
