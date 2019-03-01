package com.infosys.productMS.dto;

import com.infosys.productMS.domain.Review;

public class ReviewDto {
	
	private Integer userId;
	private Integer productId;
	private Float rating;
	private String reviewComment;
	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewDto(Integer userId, Integer productId, Float rating, String reviewComment) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.rating = rating;
		this.reviewComment = reviewComment;
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
	
	public static Review toDomain(ReviewDto rdto) {
		return new Review(null,rdto.userId, rdto.productId, rdto.rating, rdto.reviewComment);
	}
	
	public static ReviewDto toDto(Review r) {
		return new ReviewDto( r.getUserId(), r.getProductId(), r.getRating(), r.getReviewComment());
	}
}
