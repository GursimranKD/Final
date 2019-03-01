package com.infosys.orderMS.service;

import java.util.List;

import com.infosys.orderMS.dto.OrderDTO;

public interface OrderService {

	Boolean addOrder(OrderDTO orderDTO);

	List<OrderDTO> getOrdersBySeller(Integer sellerId);

	List<OrderDTO> getOrdersByUser(Integer userId);

	Boolean cancelOrder(Integer orderId);

	Boolean deliverOrder(Integer orderId);

	Boolean returnOrder(Integer orderId) throws Exception;
	
}
