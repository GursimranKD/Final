package com.infosys.productMS.service;

import java.util.List;


import com.infosys.productMS.dto.ReviewDto;

public interface ReviewService {
	public List<ReviewDto> getProductReviews(Integer productId);
	
	public ReviewDto addReview(ReviewDto reviewDto);
}
