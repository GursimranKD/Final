package com.infy.Ekart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wishlist {
	
	@Id
	@GeneratedValue
	private Integer WishlistId;
	private Integer userId;
	private Integer productId;
	private String displayName;
	private String shortdesc;
	private String category;
	private Integer sellerId;
	
	
	
	public Wishlist(Integer wishlistId, Integer userId, Integer productId, String displayName, String shortdesc,
			String category, Integer sellerId) {
		super();
		WishlistId = wishlistId;
		this.userId = userId;
		this.productId = productId;
		this.displayName = displayName;
		this.shortdesc = shortdesc;
		this.category = category;
		this.sellerId = sellerId;
	}


	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getWishlistId() {
		return WishlistId;
	}
	public void setWishlistId(Integer wishlistId) {
		WishlistId = wishlistId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getShortdesc() {
		return shortdesc;
	}
	public void setShortdesc(String shortdesc) {
		this.shortdesc = shortdesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
