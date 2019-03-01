package com.infosys.cartMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.cartMS.domain.Cart;
import com.infosys.cartMS.dto.CartDto;
import com.infosys.cartMS.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepository;
	

	
	@Override
	public CartDto addToCart(CartDto cartDto) throws Exception{
		
		if(cartDto.getQuantity()>4) throw new Exception("Cannot add more than 4 quantities");
		Cart c = cartRepository.findByUserIdAndProductIdAndSellerId(cartDto.getUserId(), cartDto.getProductId(), cartDto.getSellerId());
		if(c!=null) {
			if(c.getQuantity()+cartDto.getQuantity()>4) throw new Exception("Exceeded 4 quantities");
			else {
				c.setQuantity(c.getQuantity()+cartDto.getQuantity());
				cartRepository.saveAndFlush(c);
				return CartDto.prepareDto(c);
			}
		}
		
		cartRepository.saveAndFlush(CartDto.prepareEntity(cartDto));
		return cartDto;
	}

	@Override
	public CartDto modifyCart(CartDto cartDto)throws Exception{
		Cart c = cartRepository.findByCartId(cartDto.getCartId());
		if(c==null) throw new Exception("Could not find the given cart");
		c.setQuantity(cartDto.getQuantity());
		if(c.getQuantity()<1) {
			cartRepository.delete(c);
			return null;
		}
		else if(c.getQuantity()>4) throw new Exception("Cannot add more than 4 quantities");
		else {
			cartRepository.saveAndFlush(c);
			return CartDto.prepareDto(c);
		}
		
	}

	@Override
	public List<CartDto> viewCartByUser(Integer userId) {
		
		List<Cart> cartList= cartRepository.findByUserId(userId);
		if(cartList==null) return null;
		List<CartDto> dtoList = new ArrayList<>();
		for(Cart c : cartList) dtoList.add(CartDto.prepareDto(c));
		return dtoList;
		}

	
	

	@Override
	public Boolean removeAllProducts(Integer userId) {		
			cartRepository.deleteByUserId(userId);
			return true;
	}
		

//	@Override
//	public Boolean removeSpecificProduct(CartDto cartDto) {
//		// TODO Auto-generated method stub
//		Cart cart= cartRepository.findByCartId(cartDto.getCartId());
//		if (cart!=null) {
//			cartRepository.delete(cart);
//			return true;
//		}
//		return false;
//	}
	
	@Override
	public Boolean removeSpecificProduct(CartDto cartDto) {
		Cart cart= cartRepository.findByUserIdAndProductIdAndSellerId(cartDto.getUserId(), cartDto.getProductId(), cartDto.getSellerId());
		if (cart!=null) {
			cartRepository.delete(cart);
			return true;
		}
		return false;	
	}

	@Override
	public List<CartDto> viewCartBySeller(Integer id){
		List<Cart> cartList= cartRepository.findBySellerId(id);
		if(cartList==null) return null;
		List<CartDto> dtoList = new ArrayList<>();
		for(Cart c : cartList) 
			dtoList.add(CartDto.prepareDto(c));
		
		return dtoList;
		
	}
};
