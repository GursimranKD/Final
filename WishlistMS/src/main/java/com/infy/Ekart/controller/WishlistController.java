package com.infy.Ekart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Ekart.DTO.WishlistDTO;
import com.infy.Ekart.service.WishlistService;


@RestController
@RequestMapping("/wishlist")
@CrossOrigin("*")
public class WishlistController {

Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WishlistService wishlistService;
	
	@GetMapping(value="/{userId}")
	public ResponseEntity<List<WishlistDTO>> getWishlist(@PathVariable("userId") Integer userId) throws Exception{
		List<WishlistDTO> dto =  wishlistService.viewWishlistByUser(userId);
		return new ResponseEntity<List<WishlistDTO>>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{userId}/{productId}/delete")
	public ResponseEntity<Boolean> deleteFromCart(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId) throws Exception{
		Boolean b = wishlistService.removeSpecificProduct(productId,userId);
		return new ResponseEntity<Boolean>(b, HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<WishlistDTO> addIntoCart(@RequestBody WishlistDTO wishlistDto) throws Exception{
		WishlistDTO dto =  wishlistService.addToWishlist(wishlistDto);
		return new ResponseEntity<WishlistDTO>(dto, HttpStatus.OK);
	}
}
