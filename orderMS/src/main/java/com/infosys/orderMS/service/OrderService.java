package com.infosys.orderMS.service;

import java.util.List;

import com.infosys.orderMS.dto.OrderDTO;
import com.infosys.orderMS.dto.ReviewDTO;

public interface OrderService {

	 public List<OrderDTO> viewOrder(Integer userId);
	   public Boolean cancelOrder(int orderId);
	   	public Boolean ReturnOrder(int orderId)  throws Exception;
	public Boolean deliverOrder(Integer orderId);
	public Boolean addOrder(OrderDTO o);
	public Boolean addProductReview(ReviewDTO reviewDTO);
	public List<OrderDTO> getOrdersBySeller(Integer sellerId);
}
