package com.infosys.orderMS.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="order_table")
public class Order {
	@Id
	@GeneratedValue
	private Integer orderId;
	private Integer userId;
	private Integer productId;
	private Integer sellerId;
	private Integer addressId;
	@Temporal(TemporalType.DATE)
	private Calendar orderDate;
	
	@Temporal(TemporalType.DATE)
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
}
