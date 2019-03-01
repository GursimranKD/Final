package com.infy.Ekart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infy.Ekart.domain.Wishlist;
import com.infy.Ekart.repository.WishlistRepository;
import com.infy.Ekart.DTO.WishlistDTO;

@Service
public class WishlistServiceImpl implements WishlistService {
	
	@Autowired
	WishlistRepository wishlistRepository;
	
	@Override
	public List<WishlistDTO> viewWishlistByUser(Integer userId) {
		
		List<Wishlist> wishList= wishlistRepository.findByUserId(userId);
		if(wishList==null) return null;
		List<WishlistDTO> dtoList = new ArrayList<>();
		for(Wishlist c : wishList) dtoList.add(WishlistDTO.prepareDto(c));
		return dtoList;
		}
	
	@Override
	public Boolean removeSpecificProduct(Integer userId, Integer productId) {
		// TODO Auto-generated method stub
		Wishlist wishlist= wishlistRepository.findByUserIdAndProductId(productId,userId);
		if (wishlist!=null) {
			wishlistRepository.delete(wishlist);
			return true;
		}
		return false;
	}
	
	@Override
	public WishlistDTO addToWishlist(WishlistDTO wishlistDto) throws Exception{
		
		Wishlist wishlist = wishlistRepository.findByUserIdAndDisplayName(wishlistDto.getUserId(), wishlistDto.getDisplayName());
		
		if(wishlist==null) {
			System.out.println(wishlistDto.getSellerId());
			wishlistRepository.saveAndFlush(WishlistDTO.prepareEntity(wishlistDto));
			return wishlistDto;
		}else {
			throw new Exception("Product already exists in the Wishlist");
		}
		
	}

	
}
