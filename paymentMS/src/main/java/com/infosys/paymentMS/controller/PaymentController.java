package com.infosys.paymentMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.paymentMS.dto.CardDto;
import com.infosys.paymentMS.exception.ServiceException;
import com.infosys.paymentMS.service.PaymentServiceImpl;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PaymentController {
	@Autowired
	PaymentServiceImpl paymentService;
	
	@GetMapping("/{userId}/getCards")
	public ResponseEntity<CardDto[]> getCards(@PathVariable("userId") Integer userId) throws Exception{
		CardDto[] finale=paymentService.getCards(userId);
		return new ResponseEntity<CardDto[]>(finale,HttpStatus.OK);
		
		
	}
	
	@PostMapping("{userId}/addCard")
	public ResponseEntity<Boolean> addCard(@RequestBody CardDto card,@PathVariable("userId") Integer userId) throws ServiceException{
		Boolean result=paymentService.addCard(card,userId);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
		
	}
	
	@PostMapping("{userId}/deleteCard")
	public ResponseEntity<Boolean> deleteCard(@RequestBody CardDto card,@PathVariable("userId") Integer userId) throws ServiceException{
		Boolean result=paymentService.deleteCard(card,userId);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	

}
