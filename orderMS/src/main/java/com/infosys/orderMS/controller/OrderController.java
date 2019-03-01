package com.infosys.orderMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.orderMS.dto.OrderDTO;
import com.infosys.orderMS.service.OrderService;

@RestController
@CrossOrigin("*")
public class OrderController {
	@Autowired
	OrderService orderService;
//	@Autowired
//    RestTemplate rt;

	
//	@GetMapping(value="{sellerId}/sellerName")
//	public String getSellerName(@PathVariable("sellerId") Integer sellerId){
//		
//		String x=rt.getForObject("http://localhost:8800/seller/"+sellerId+"/sellerName",String.class);
//		
//		return x;
//	}
	
	
	@GetMapping(value="{sellerId}/sellerorder")
	public List<OrderDTO> getOrdersBySeller(@PathVariable("sellerId") Integer sellerId){
		return orderService.getOrdersBySeller(sellerId);
	}
	
	@GetMapping(value="{userId}/orders")
	public List<OrderDTO> getOrdersByUser(@PathVariable("userId") Integer userId){
		return orderService.getOrdersByUser(userId);
		
	}
	
	@PostMapping(value="order/add")
	public Boolean addOrders(@RequestBody List<OrderDTO> orderList) {
		System.out.println("im in order controller");
		for(OrderDTO o: orderList) {
			System.out.println("inside for loop");
			orderService.addOrder(o);
			
		}
		return true;
	}
	
	@GetMapping(value="{orderId}/cancel")
	public Boolean cancelOrder(@PathVariable("orderId") Integer orderId) {
		System.out.println("Inside Controller: "+orderId);
		return orderService.cancelOrder(orderId);
	}
	
	@GetMapping(value="{orderId}/return")
	public Boolean returnOrder(@PathVariable("orderId") Integer orderId) throws Exception {
		return orderService.returnOrder(orderId);
	}
	
	@GetMapping(value="{orderId}/deliver")
	
	public Boolean deliverOrder(@PathVariable("orderId") Integer orderId) {
		
		return orderService.deliverOrder(orderId);
	}
}
