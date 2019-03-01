package com.infosys.productMS.dto;


import com.infosys.productMS.domain.Product;
import com.infosys.productMS.domain.ProductIds;


public class ProductDto {
	
	private ProductIds productIds;
	private String displayName;
	private String shortDesc;
	private String desc;	
	private String category;
	private Double price;
	private Double discount;
	private Double offerPrice;	
	private Double deliveryCharge;
	private Integer quantity;
	
	public ProductDto() {
		super();
		
	}

	public ProductDto(ProductIds productIds, String displayName, String shortDesc, String desc, String category,
			Double price, Double discount,Double offerPrice, Double deliveryCharge, Integer quantity) {
		super();
		this.productIds = productIds;
		this.displayName = displayName;
		this.shortDesc = shortDesc;
		this.desc = desc;
		this.category = category;
		this.price = price;
		this.discount = discount;
		this.offerPrice = offerPrice;
		this.deliveryCharge = deliveryCharge;
		this.quantity = quantity;
	}

	public ProductIds getProductIds() {
		return productIds;
	}

	public void setProductIds(ProductIds productIds) {
		this.productIds = productIds;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(Double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public static Product toDomain(ProductDto psd) {
		
		
		Product product = new Product(psd.productIds, psd.displayName, psd.shortDesc, psd.desc, psd.category, psd.price, psd.discount, psd.deliveryCharge, psd.offerPrice, psd.quantity);
		return product;
	}
	
	public static ProductDto toDto(Product p) {
		ProductDto pd = new ProductDto(p.getProductIds(), p.getDisplayName(), p.getShortDesc(), p.getDesc(), p.getCategory(), p.getPrice(), p.getDiscount(), p.getOfferPrice(),p.getDeliveryCharge(), p.getQuantity());
		return pd;
	}

	public Double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}
	
	

}


