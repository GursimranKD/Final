package com.infosys.orderMS.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.orderMS.domain.Order;
import com.infosys.orderMS.domain.Review;
import com.infosys.orderMS.dto.OrderDTO;
import com.infosys.orderMS.dto.ReviewDTO;
import com.infosys.orderMS.repository.OrderRepository;
import com.infosys.orderMS.repository.ReviewRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository ordrepo;
	
	@Autowired
	private ReviewRepository revrepo;
	
	@Override
	public List<OrderDTO> viewOrder(Integer userId) {
		System.out.println("inside service");
		List<OrderDTO> or=new ArrayList<>();
	
		for(Order o: ordrepo.findByUserId(userId)) {
			or.add(OrderDTO.EntitytoDTO(o));
		}
		return or;
	}

	@Override
	public Boolean cancelOrder(int orderId) {
	
		Order order=ordrepo.findByOrderId(orderId);
		if(order!=null)  {
			if(order.getOrderStatus().equalsIgnoreCase("open")) {
				order.setOrderStatus("cancelled");
				//System.out.println("updating");
				ordrepo.save(order);
				return true;
		}
		
		}
		return false;
	}
	public static long daysBetween(Calendar startDate, Calendar endDate) {
	    long end = endDate.getTimeInMillis();
	    long start = startDate.getTimeInMillis();
	    return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
	}

	@Override
	public Boolean ReturnOrder(int orderId) throws Exception{
		
		Order order = ordrepo.findByOrderId(orderId);
		if(order!=null) {
			if(order.getOrderStatus().equalsIgnoreCase("delivered")) {
				long days = daysBetween(order.getDeliveryDate(), Calendar.getInstance());
				if(days<=10) {
				order.setOrderStatus("returned");
				ordrepo.save(order);
				return true;
				}else {
					throw new Exception("Already 10 days have passed");
				}
				
			}
		}
		return false;
	}


	  @Override
		public Boolean deliverOrder(Integer orderId) {
	    	
			Order order = ordrepo.findByOrderId(orderId);
			if(order!=null) {
				if(order.getOrderStatus().equalsIgnoreCase("open")) {
					order.setOrderStatus("delivered");
					order.setDeliveryDate(Calendar.getInstance());
					ordrepo.save(order);
					
					return true;
				}
			}
			return false;
		}

	@Override
	public Boolean addOrder(OrderDTO o) {
		try {
			o.setOrderStatus("open");
		    o.setOrderDate(Calendar.getInstance());
			Order or=OrderDTO.DTOtoEntity(o);
			ordrepo.save(or);			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean addProductReview(ReviewDTO reviewDTO) {
		try {
		Review review = ReviewDTO.DTOtoEntity(reviewDTO);
		revrepo.saveAndFlush(review);
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<OrderDTO> getOrdersBySeller(Integer sellerId) {
		List<OrderDTO> orderList = new ArrayList<>();
		for(Order o: ordrepo.findBySellerId(sellerId)) {
			orderList.add(OrderDTO.EntitytoDTO(o));
		}
		return orderList;
	}

}
