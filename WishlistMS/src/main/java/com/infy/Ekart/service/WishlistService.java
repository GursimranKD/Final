package com.infy.Ekart.service;

import java.util.List;

import com.infy.Ekart.DTO.WishlistDTO;

public interface WishlistService {

	List<WishlistDTO> viewWishlistByUser(Integer userId);

//	public Boolean removeSpecificProduct(WishlistDTO wishlistDto,Integer userId);

	public WishlistDTO addToWishlist(WishlistDTO wishlistDto) throws Exception;

	public Boolean removeSpecificProduct(Integer userId, Integer productId);

}
