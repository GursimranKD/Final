package com.infosys.orderMS.dto;

import java.util.Calendar;

import com.infosys.orderMS.domain.Order;

public class OrderDTO {
	private Integer orderId;
	private Integer userId;
	private Integer productId;
	private Integer sellerId;
	private Integer addressId;
	private Calendar orderDate;
	private Calendar deliveryDate;
	private String orderStatus;
	private Integer quantity;
	private Double totalPrice;
	

	public OrderDTO() {
		
	}
	
	
	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public Integer getSellerId() {
		return sellerId;
	}


	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}


	public Integer getAddressId() {
		return addressId;
	}


	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}


	public Calendar getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}


	public Calendar getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public OrderDTO(Integer orderId, Integer userId, Integer productId, Integer sellerId, Integer addressId,
			Calendar orderDate,Calendar deliveryDate, String orderStatus, Integer quantity, Double totalPrice) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.sellerId = sellerId;
		this.addressId = addressId;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}


	public static OrderDTO prepareDto(Order order) {
		OrderDTO orderDTO=new OrderDTO();
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setUserId(order.getUserId());
		orderDTO.setProductId(order.getProductId());
		orderDTO.setSellerId(order.getSellerId());
		orderDTO.setAddressId(order.getAddressId());
		orderDTO.setOrderDate(order.getOrderDate());
		orderDTO.setDeliveryDate(order.getDeliveryDate());
		orderDTO.setOrderStatus(order.getOrderStatus());
		orderDTO.setQuantity(order.getQuantity());
		orderDTO.setTotalPrice(order.getTotalPrice());
		return orderDTO;
	}
	public static Order prepareEntity(OrderDTO orderDTO) {
		Order order=new Order();
		order.setOrderId(orderDTO.getOrderId());
		order.setUserId(orderDTO.getUserId());
		order.setProductId(orderDTO.getProductId());
		order.setSellerId(orderDTO.getSellerId());
		order.setAddressId(orderDTO.getAddressId());
		order.setOrderDate(orderDTO.getOrderDate());
		order.setDeliveryDate(orderDTO.getDeliveryDate());
		order.setOrderStatus(orderDTO.getOrderStatus());
		System.out.println(order.getOrderStatus());
		order.setQuantity(orderDTO.getQuantity());
		order.setTotalPrice(orderDTO.getTotalPrice());
		return order;
	}
}
