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
import com.infosys.orderMS.dto.ReviewDTO;
import com.infosys.orderMS.service.OrderService;

@RestController
@CrossOrigin("*")
public class OrderController {
	@Autowired
	private OrderService orderService;
	


@GetMapping(value="{userId}/orders")
	
	public List<OrderDTO> viewOrder(@PathVariable("userId") Integer userId) {
	System.out.println("inside controller");
	
		return orderService.viewOrder(userId);
	}

@GetMapping("{orderId}/cancel")

public Boolean CancelOrder(@PathVariable("orderId") int orderId){
	return orderService.cancelOrder(orderId);
}

@GetMapping(value="{orderId}/return")

public Boolean returnOrder(@PathVariable("orderId") Integer orderId) throws Exception {
	return orderService.ReturnOrder(orderId);
}

@PostMapping(value="order/add")
public Boolean addOrders(@RequestBody List<OrderDTO> orderList) {
	for(OrderDTO o: orderList) {
		orderService.addOrder(o);
		
	}
	return true;
}


@GetMapping(value="{orderId}/deliver")

public Boolean deliverOrder(@PathVariable("orderId") Integer orderId) {
	
	return orderService.deliverOrder(orderId);
}

@PostMapping(value="/product/review")
public Boolean getProductReviews(@RequestBody ReviewDTO reviewDTO){

	return 	orderService.addProductReview(reviewDTO);
}
@GetMapping(value="{sellerId}/sellerorder")
public List<OrderDTO> getOrdersBySeller(@PathVariable("sellerId") Integer sellerId){
	return orderService.getOrdersBySeller(sellerId);
}
}
