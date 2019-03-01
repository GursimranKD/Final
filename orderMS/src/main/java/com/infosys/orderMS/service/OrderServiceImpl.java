package com.infosys.orderMS.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.orderMS.domain.Order;
import com.infosys.orderMS.dto.OrderDTO;
import com.infosys.orderMS.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderRepository orderRepository;
	
	
    public static long daysBetween(Calendar startDate, Calendar endDate) {
		    long end = endDate.getTimeInMillis();
		    long start = startDate.getTimeInMillis();
		    return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
    	}
    
    @Override
	public Boolean addOrder(OrderDTO orderDTO) {
		try {
		    orderDTO.setOrderStatus("open");
		    orderDTO.setOrderDate(Calendar.getInstance());
			System.out.println(orderDTO.getOrderStatus());
			Order o=OrderDTO.prepareEntity(orderDTO);
			System.out.println(o.getOrderStatus());
			orderRepository.save(o);			
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
    @Override
	public List<OrderDTO> getOrdersBySeller(Integer sellerId){
		List<OrderDTO> orderList = new ArrayList<>();
		for(Order o: orderRepository.findBySellerId(sellerId)) {
			orderList.add(OrderDTO.prepareDto(o));
		}
		return orderList;
	}
	
    @Override
	public List<OrderDTO> getOrdersByUser(Integer userId){
		List<OrderDTO> orderList = new ArrayList<>();
		for(Order o: orderRepository.findByUserId(userId)) {
			orderList.add(OrderDTO.prepareDto(o));
		}
		return orderList;
	}
	
    @Override
	public Boolean cancelOrder(Integer orderId) {
    	//System.out.println("Inside Service: "+orderId);
		Order order = orderRepository.findByOrderId(orderId);
		if(order!=null) {
			//System.out.println("Order found: ");
			if(order.getOrderStatus().equalsIgnoreCase("open")) {
				order.setOrderStatus("cancelled");
				//System.out.println("updating");
				orderRepository.save(order);
//				Double moneyReturned = order.getTotalPrice();
//				talk with payment and send moneyReturned and userid
				return true;
			}
		}
		return false;
	}
	
    @Override
	public Boolean deliverOrder(Integer orderId) {
    	
		Order order = orderRepository.findByOrderId(orderId);
		if(order!=null) {
			if(order.getOrderStatus().equalsIgnoreCase("open")) {
				order.setOrderStatus("delivered");
				order.setDeliveryDate(Calendar.getInstance());
				orderRepository.save(order);
				
				return true;
			}
		}
		return false;
	}
	
    @Override
	public Boolean returnOrder(Integer orderId) throws Exception{
		Order order = orderRepository.findByOrderId(orderId);
		if(order!=null) {
			if(order.getOrderStatus().equalsIgnoreCase("delivered")) {
				long days = daysBetween(order.getDeliveryDate(), Calendar.getInstance());
				if(days<=10) {
				order.setOrderStatus("returned");
				orderRepository.save(order);
				return true;
				}else {
					throw new Exception("Already 10 days have passed");
				}
				
			}
		}
		return false;
	}
	
	
}
