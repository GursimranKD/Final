package com.infosys.cartMS.service;

import java.util.List;

import com.infosys.cartMS.domain.Cart;
import com.infosys.cartMS.dto.CartDto;


public interface CartService {
	
	public CartDto addToCart(CartDto cartDto) throws Exception;	
	
	public CartDto modifyCart(CartDto cartDto)throws Exception;
	
	public List<CartDto> viewCartByUser(Integer userId);	
	
	//public Integer viewCartCount(Integer userId);
	
	//public Product getIndividualProduct(Integer productId, Integer sellerId);
	
	public Boolean removeAllProducts(Integer userId);
	
	public Boolean removeSpecificProduct(CartDto cartDto);
	
	public List<CartDto> viewCartBySeller(Integer id);
	
	
	
	

	
}
