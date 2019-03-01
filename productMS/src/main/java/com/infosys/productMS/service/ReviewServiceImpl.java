package com.infosys.productMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.productMS.domain.Review;
import com.infosys.productMS.dto.ReviewDto;
import com.infosys.productMS.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;

	@Override
	public List<ReviewDto> getProductReviews(Integer productId) {
		List<Review> revList = reviewRepository.findByProductId(productId);
		List<ReviewDto> revDtoList = new ArrayList<>();
		for(Review r:revList){
			revDtoList.add(ReviewDto.toDto(r));
		}
		return revDtoList;
	}
	
	@Override
	public ReviewDto addReview(ReviewDto reviewDto) {
		Review review = ReviewDto.toDomain(reviewDto);
		reviewRepository.saveAndFlush(review);
		return reviewDto;
	}
}
