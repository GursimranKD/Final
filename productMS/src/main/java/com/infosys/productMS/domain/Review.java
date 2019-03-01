package com.infosys.productMS.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Integer reviewId;
	private Integer userId;
	private Integer productId;
	private Float rating;
	private String reviewComment; 
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(Integer reviewId,Integer userId, Integer productId, Float rating, String reviewComment) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.productId = productId;
		this.rating = rating;
		this.reviewComment = reviewComment;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
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

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	
	
	
	
	

}
