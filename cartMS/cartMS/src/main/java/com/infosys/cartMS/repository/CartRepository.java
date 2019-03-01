package com.infosys.cartMS.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infosys.cartMS.domain.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer> {
	public List<Cart> findByUserId(Integer userId);
	public List<Cart> findBySellerId(Integer sellerId);
	public Cart findByCartId(Integer cartId);
	
	
	public Cart findByUserIdAndProductIdAndSellerId(Integer userId, Integer productId, Integer sellerId);
	
	
	@Modifying
	@Transactional
	@Query(value="delete from Cart c where c.userId = ?1")
	void deleteByUserId(Integer userId);
	
	
}