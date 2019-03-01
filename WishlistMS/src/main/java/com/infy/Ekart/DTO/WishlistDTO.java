package com.infy.Ekart.DTO;

import com.infy.Ekart.domain.Wishlist;

public class WishlistDTO {
	
	private Integer WishlistId;
	private Integer userId;
	private Integer productId;
	private String displayName;
	private String shortdesc;
	private String category;
	private Integer sellerId;
	
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
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
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
	
	
	
	public WishlistDTO(Integer wishlistId, Integer userId, Integer productId, String displayName, String shortdesc,
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
	public WishlistDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Wishlist prepareEntity(WishlistDTO dto) {
		return new Wishlist (dto.WishlistId, dto.userId, dto.productId ,dto.displayName, dto.shortdesc, dto.category,dto.sellerId);
	}
	
	public static WishlistDTO prepareDto(Wishlist c) {
		return new WishlistDTO(c.getWishlistId(), c.getUserId(), c.getProductId(),c.getDisplayName(), c.getShortdesc(), c.getCategory(),c.getSellerId());
	}
}
