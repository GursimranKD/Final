package com.infosys.orderMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.orderMS.domain.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
