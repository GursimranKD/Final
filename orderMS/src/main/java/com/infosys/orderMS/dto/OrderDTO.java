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
	public static Order DTOtoEntity(OrderDTO orderDTO) {
		Order order=new Order();
		order.setAddressId(orderDTO.getAddressId());
		order.setDeliveryDate(orderDTO.getDeliveryDate());
		order.setOrderDate(orderDTO.getDeliveryDate());
		order.setOrderId(orderDTO.getOrderId());
		order.setOrderStatus(orderDTO.getOrderStatus());
		order.setProductId(orderDTO.getProductId());
		order.setQuantity(orderDTO.getQuantity());
		order.setSellerId(orderDTO.getSellerId());
		order.setTotalPrice(orderDTO.getTotalPrice());
		order.setUserId(orderDTO.getUserId());
		return order;
	}
	public static OrderDTO EntitytoDTO(Order orderDTO) {
		OrderDTO order=new OrderDTO();
		order.setAddressId(orderDTO.getAddressId());
		order.setDeliveryDate(orderDTO.getDeliveryDate());
		order.setOrderDate(orderDTO.getDeliveryDate());
		order.setOrderId(orderDTO.getOrderId());
		order.setOrderStatus(orderDTO.getOrderStatus());
		order.setProductId(orderDTO.getProductId());
		order.setQuantity(orderDTO.getQuantity());
		order.setSellerId(orderDTO.getSellerId());
		order.setTotalPrice(orderDTO.getTotalPrice());
		order.setUserId(orderDTO.getUserId());
		return order;
	}
}

