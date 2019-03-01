package com.infosys.productMS.domain;




import javax.persistence.EmbeddedId;
import javax.persistence.Entity;





@Entity
public class Product {
	@EmbeddedId
	private ProductIds productIds;
	private String displayName;
	private String shortDesc;
	private String desc;
	
	private String category;
	private Double price;
	private Double discount;
	private Double deliveryCharge;
	private Double offerPrice;	
	private Integer quantity;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(ProductIds productIds, String displayName, String shortDesc, String desc, String category,
			Double price, Double discount, Double deliveryCharge, Double offerPrice, 
			Integer quantity) {
		super();
		this.productIds = productIds;
		this.displayName = displayName;
		this.shortDesc = shortDesc;
		this.desc = desc;
		this.category = category;
		this.price = price;
		this.discount = discount;
		this.deliveryCharge = deliveryCharge;
		this.offerPrice = offerPrice;
		
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

	public Double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}

	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	
}
