package com.infosys.productMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.productMS.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	public List<Review> findByProductId(Integer productId);
}
