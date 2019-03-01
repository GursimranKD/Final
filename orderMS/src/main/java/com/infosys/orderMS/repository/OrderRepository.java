package com.infosys.orderMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.orderMS.domain.Order;



@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
	public List<Order> findByUserId(Integer userId);
	public Order findByOrderId(Integer orderId);

	public List<Order> findBySellerId(Integer sellerId);
}
