package com.infosys.cartMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.cartMS.dto.CartDto;
import com.infosys.cartMS.service.CartService;


@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CartService cartService;
	
	@GetMapping(value="/{userId}")
	public ResponseEntity<List<CartDto>> getCart(@PathVariable("userId") Integer userId) throws Exception{
		List<CartDto> dto =  cartService.viewCartByUser(userId);
		return new ResponseEntity<List<CartDto>>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<CartDto> addIntoCart(@RequestBody CartDto cartDto) throws Exception{
		CartDto dto =  cartService.addToCart(cartDto);
		return new ResponseEntity<CartDto>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<Boolean> deleteFromCart(@RequestBody CartDto cartDto) throws Exception{
		Boolean b = cartService.removeSpecificProduct(cartDto);
		return new ResponseEntity<Boolean>(b, HttpStatus.OK);
				
	}
	
	@DeleteMapping(value="/{userId}/delete")
	public ResponseEntity<Boolean> deleteAllFromCart(@PathVariable("userId") Integer userId) throws Exception{
		Boolean b = cartService.removeAllProducts(userId);
		return new ResponseEntity<Boolean>(b, HttpStatus.OK);
				
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<CartDto> updateCart(@RequestBody CartDto cartDto) throws Exception{
		CartDto dto =  cartService.modifyCart(cartDto);
		return new ResponseEntity<CartDto>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value="/getSellerProducts/{sellerId}")
	public ResponseEntity<List<CartDto>> getSellerProducts(@PathVariable("sellerId") Integer sellerId){
		List<CartDto> cartList=cartService.viewCartBySeller(sellerId);
		return new ResponseEntity<List<CartDto>>(cartList,HttpStatus.OK);
	}
	
}

