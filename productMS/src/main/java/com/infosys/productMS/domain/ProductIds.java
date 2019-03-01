package com.infosys.productMS.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;


@Embeddable

public class ProductIds implements Serializable {
	
    
	private static final long serialVersionUID = 1L;
	//@Id
    @GeneratedValue
    private Integer productId;   
    private Integer sellerId;
    
    
    
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
	
	@Override
	public boolean equals(Object  o) {
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductIds ids = (ProductIds) o;      
		if(ids.getProductId()==this.productId && ids.getSellerId()==this.sellerId) return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	public ProductIds() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductIds(Integer sellerId) {
		super();
		this.sellerId = sellerId;
	}

	
    
}