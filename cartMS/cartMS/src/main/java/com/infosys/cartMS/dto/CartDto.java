package com.infosys.cartMS.dto;

import com.infosys.cartMS.domain.Cart;

public class CartDto {
	
	private Integer cartId;
	private Integer userId;
	private Integer productId;
	private Integer sellerId;
	private Integer quantity;
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public CartDto(Integer cartId, Integer userId, Integer productId, Integer sellerId, Integer quantity) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.sellerId = sellerId;
		this.quantity = quantity;
	}
	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	public static Cart prepareEntity(CartDto dto) {
		return new Cart(dto.cartId, dto.userId, dto.productId, dto.sellerId, dto.quantity);
	}
	
	
	public static CartDto prepareDto(Cart c) {
		return new CartDto(c.getCartId(), c.getUserId(), c.getProductId(), c.getSellerId(), c.getQuantity());
	}
}
