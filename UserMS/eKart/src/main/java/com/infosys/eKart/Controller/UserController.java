package com.infosys.eKart.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.eKart.Domain.User;
import com.infosys.eKart.Dto.AddressDto;
import com.infosys.eKart.Dto.UserDto;
import com.infosys.eKart.Service.UserServ;

@RestController
@CrossOrigin(origins="*")
public class UserController {

	  @Autowired
	   UserServ userService;
	  
       @PostMapping(value="/login")
       public ResponseEntity<UserDto> hello(@RequestBody UserDto userDto){
    	     UserDto val = userService.loginCheck(userDto);
    	    
    	     
    	 return new ResponseEntity<UserDto>(val, HttpStatus.OK); 
              
       }
       
       
       @GetMapping(value="/{username}/details")
       public ResponseEntity<User> productDetails(@PathVariable("username") String userName){
              System.out.println("fetching: "+ userName);
              User user = userService.getUser();
              return new ResponseEntity<User>(user, HttpStatus.OK);
              
       }
       
      // http://localhost:5000/signup
       @PostMapping(value="/signup")
       public ResponseEntity<String> addCustomer(@Valid @RequestBody UserDto userDto,BindingResult error) throws Exception{
           if(error.hasErrors()) {
        	   System.out.println(error);
           }
           else {
    	   userService.addCust(userDto);
    	      System.out.println("add");
              return new ResponseEntity<String>("customer added", HttpStatus.OK);
              }
           return new ResponseEntity<String>("not added", HttpStatus.OK);  
       }
       
       
      // http://localhost:5000/<userid>/update
       @PutMapping(value="{userid}/update")
       public ResponseEntity<String> updateCustomer(@PathVariable("userid") Integer userid,
    		                                        @Valid @RequestBody UserDto userDto,BindingResult error){
           if(error.hasErrors()) {
        	   System.out.println(error);
           }
           else {
    	   userService.modifyCust(userDto,userid);
              return new ResponseEntity<String>("customer modified", HttpStatus.OK);
              }
           return new ResponseEntity<String>("not modified", HttpStatus.OK);  
       }

}
