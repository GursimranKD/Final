package com.infosys.eKart.Service;

import javax.validation.Valid;

import com.infosys.eKart.Domain.User;
import com.infosys.eKart.Dto.UserDto;

public interface UserServ {
	public User getUser();

	public void addCust(UserDto userDto) throws Exception;

	public void modifyCust(@Valid UserDto userDto, Integer userid);

	public UserDto loginCheck(UserDto userDto);

}
