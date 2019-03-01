package com.infosys.orderMS.dto;

import com.infosys.orderMS.domain.Review;

public class ReviewDTO {
	private Integer reviewId;
	private Integer userId;
	private Integer productId;
	private Float rating;
	private String reviewComment;
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
	public static Review DTOtoEntity(ReviewDTO reviewDTO) {
		Review r=new Review();
		r.setProductId(reviewDTO.getProductId());
		r.setRating(reviewDTO.getRating());
		r.setReviewComment(reviewDTO.getReviewComment());
		r.setReviewId(reviewDTO.getReviewId());
		return r;
	}
	public static ReviewDTO EntitytoDTO(Review review) {
		ReviewDTO r=new ReviewDTO();
		r.setProductId(review.getProductId());
		r.setRating(review.getRating());
		r.setReviewComment(review.getReviewComment());
		r.setReviewId(review.getReviewId());
		return r;
	}

}
