package com.infy.ekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ekart.entity.Address;
import com.infy.ekart.exceptions.NoEntriesFound;
import com.infy.ekart.exceptions.UserNotAllowedException;
import com.infy.ekart.dto.AddressDto;
import com.infy.ekart.service.AddressService;


@RestController
@CrossOrigin(origins="*")
public class AddressController {
	
	 @Autowired
	   AddressService addressService;
	 
	 //demo 
     @GetMapping(value="/hello1")
     public ResponseEntity<String> hello(){
            return new ResponseEntity<String>("Hello1", HttpStatus.OK);
            
     }
     
     
     @GetMapping(value="/{userid}/address/addressdetails")
     public ResponseEntity<List<Address>> addressDetails(@PathVariable("userid") String email) throws NoEntriesFound{
            //System.out.println("fetching: "+ userId);
            List<Address> list1 = addressService.getAddress(email);
            return new ResponseEntity<List<Address>>(list1, HttpStatus.OK);
            
     }
     

     @PutMapping(value="/{userid}/address/{addressid}/modify")
     public ResponseEntity<String> modifyAddress(@PathVariable("userid") String email,
    		 @PathVariable("addressid") Integer addressid, @RequestBody AddressDto address)
     {
    	 	ResponseEntity<String> rs;
    	     try {
				addressService.modifyAddress(email,addressid,address);
			} catch (UserNotAllowedException e) {
				// TODO Auto-generated catch block
				rs=new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
			}
    	     rs=new ResponseEntity<String>("modify", HttpStatus.OK);
            return rs;
     }
     
     
     @DeleteMapping(value="/{userid}/address/{addressid}/delete")
     public ResponseEntity<String> deleteAddress(@PathVariable("userid") String userid,
    		 @PathVariable("addressid") Integer addressid) 
     {
    	 	ResponseEntity<String> rs;
    	 	System.out.println("delete");
    	    try {
				addressService.deleteAddress(userid,addressid);
				System.out.println("try");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				rs=new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
				return rs;
			}
			
            rs = new ResponseEntity<String>("delete", HttpStatus.OK);
            return rs;
     }
     
     @PostMapping(value="{userid}/address/add")
     public ResponseEntity<String> addAddress(@PathVariable("userid") String userid,@RequestBody AddressDto address){
    	    addressService.addAddress(userid,address);
            return new ResponseEntity<String>("add", HttpStatus.OK);
            
     }
     
     

}
