package com.infy.Ekart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.Ekart.DTO.WishlistDTO;
import com.infy.Ekart.domain.Wishlist;

public interface WishlistRepository extends JpaRepository <Wishlist, Integer> {
	
	public List<Wishlist> findByUserId(Integer userId);
	//public Wishlist findByWishlistId(Integer WishlistId);
	
//	@Modifying
//	@Transactional
//	@Query(value="delete from Wishlist c where c.displayName = ?1")
	

	public Wishlist findByUserIdAndDisplayName(Integer userId, String displayName);

	//public void saveAndFlush(WishlistDTO prepareEntity);
	
	public Wishlist findByUserIdAndProductId(Integer productId, Integer userId);
	
}
