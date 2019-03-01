package com.infosys.productMS.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;


import com.infosys.productMS.domain.Product;
import com.infosys.productMS.domain.ProductIds;

import com.infosys.productMS.dto.ProductDto;
import com.infosys.productMS.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product getProduct() {
		ProductIds pids= new ProductIds();
		//pids.setProductId(productId);
		pids.setSellerId(1001);
//		Category cat = new Category();
//		cat.setCategoryId(1);
//		cat.setCategoryName("Mobile");
		//Review review = new Review(1, 101, 120, 5f, "Good");
		//new Product(productIds, displayName, shortDesc, desc, category, price, discount, deliveryCharge, offerPrice, reviews, quantity)
		Product p = new Product(pids, "Lenovo", "Stylish Phone","Lenovo is the best", "Mobile", 15000d, 0d, 0d, 0d,  20);
		return p;
	}
	
	//to fetch the list of products based on product name
	@Override
	public List<ProductDto> getProductByProductName(String productName) {
		List<Product> prodList = productRepository.findByDisplayNameIgnoreCaseContaining(productName);
		List<ProductDto> pdList = new ArrayList<>();
		if(prodList!=null) {			
			for(Product p: prodList ) {
				pdList.add(ProductDto.toDto(p));
			}
		}
		return pdList;
	}
	
	//to fetch the list of products based on sellerId
	@Override
	public List<ProductDto> getProductBySeller(Integer sellerId) {
		List<Product> prodList = productRepository.findByProductIdsSellerId(sellerId);
		List<ProductDto> pdList = new ArrayList<>();
		if(prodList!=null) {			
			for(Product p: prodList ) {
				pdList.add(ProductDto.toDto(p));
			}
		}
		return pdList;
	}
	
	//to add a new Product
	@Override
	public ProductDto addProduct(ProductDto  productDto) {
		productDto.getProductIds().setProductId(productRepository.getMaxProductId()+1);
		productRepository.saveAndFlush(ProductDto.toDomain(productDto));
		return productDto;
	}
	
	//to update product
	@Override
	@Transactional
	@Modifying(clearAutomatically=true)
	public ProductDto updateProduct(ProductDto productDto) {
		Product prod = productRepository.findByProductIds(productDto.getProductIds());
		if(prod!=null) {
			productRepository.save(ProductDto.toDomain(productDto));
			return productDto;
		}
		return null;
	}
	
	//to delete product
	@Override
	@Transactional
	@Modifying(clearAutomatically=true)
	public boolean deleteProduct(ProductDto productDto) {
		Product prod = productRepository.findByProductIds(productDto.getProductIds());
		if(prod!=null) {
			productRepository.delete(prod);
			return true;
		}
		return false;
	}
	
	@Override
	public ProductDto getProductDetails(Integer productId, Integer sellerId) {
		ProductIds pids = new ProductIds();
		pids.setProductId(productId);
		pids.setSellerId(sellerId);
		Product prod = productRepository.findByProductIds(pids);
		return ProductDto.toDto(prod);
	}
	
	@Override
	public List<ProductDto> getTodayDeal() {
		List<Product> prodList = productRepository.getTodayDeal(new PageRequest(0,10));
		List<ProductDto> pdList = new ArrayList<>();
		if(prodList!=null) {			
			for(Product p: prodList ) {
				pdList.add(ProductDto.toDto(p));
			}
		}
		return pdList;
		
	}
	
}
