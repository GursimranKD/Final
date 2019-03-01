package com.infosys.productMS.service;

import java.util.List;

import com.infosys.productMS.domain.Product;

import com.infosys.productMS.dto.ProductDto;

public interface ProductService {
	public Product getProduct();
	
	public List<ProductDto> getProductByProductName(String productName);
	
	public ProductDto getProductDetails(Integer productId, Integer sellerId);
	
	public ProductDto addProduct(ProductDto product);
	
	public List<ProductDto> getProductBySeller(Integer sellerId);
	
	public ProductDto updateProduct(ProductDto productDto);
	
	public boolean deleteProduct(ProductDto productDto);
	
	public List<ProductDto> getTodayDeal();
	
	
}
