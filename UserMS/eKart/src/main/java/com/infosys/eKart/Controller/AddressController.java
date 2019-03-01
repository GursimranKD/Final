package com.infosys.eKart.Controller;

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

import com.infosys.eKart.Domain.Address;
import com.infosys.eKart.Domain.User;
import com.infosys.eKart.Dto.AddressDto;
import com.infosys.eKart.Service.AddressService;


@RestController
@CrossOrigin
public class AddressController {
	
	 @Autowired
	   AddressService addressService;
	 
	 //demo 
     @GetMapping(value="/hello1")
     public ResponseEntity<String> hello(){
            return new ResponseEntity<String>("Hello1", HttpStatus.OK);
            
     }
     
     
     @GetMapping(value="/{userid}/address/addressdetails")
     public ResponseEntity<List<Address>> addressDetails(@PathVariable("userid") Integer userId){
            System.out.println("fetching: "+ userId);
            List<Address> list1 = addressService.getAddress(userId);
            return new ResponseEntity<List<Address>>(list1, HttpStatus.OK);
            
     }
     

     @PutMapping(value="/{userid}/address/{addressid}/modify")
     public ResponseEntity<String> modifyAddress(@PathVariable("userid") Integer userid,
    		 @PathVariable("addressid") Integer addressid, @RequestBody AddressDto address)
     {
    	     addressService.modifyAddress(userid,addressid,address);
            return new ResponseEntity<String>("modify", HttpStatus.OK);
            
     }
     
     
     @DeleteMapping(value="/{userid}/address/{addressid}/delete")
     public ResponseEntity<String> deleteAddress(@PathVariable("userid") Integer userid,
    		 @PathVariable("addressid") Integer addressid)
     {
    	 System.out.println("delete");
    	     addressService.deleteAddress(userid, addressid);
            return new ResponseEntity<String>("delete", HttpStatus.OK);
            
     }
     
     @PostMapping(value="/{userid}/address/add")
     public ResponseEntity<String> addAddress(@PathVariable("userid") Integer userid,@RequestBody AddressDto address){
    	     addressService.addAddress(userid,address);
            return new ResponseEntity<String>("add", HttpStatus.OK);
            
     }
     
     

}
