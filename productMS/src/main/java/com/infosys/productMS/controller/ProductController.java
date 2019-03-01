package com.infosys.productMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.infosys.productMS.dto.ProductDto;
import com.infosys.productMS.dto.ReviewDto;
import com.infosys.productMS.service.ProductService;
import com.infosys.productMS.service.ReviewService;

@RestController
//@CrossOrigin
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ReviewService reviewService;

	@GetMapping(value="/hello")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
		
	}
	
	
	
	//to get today's deal
		@GetMapping(value="/todaydeal")
		public ResponseEntity<List<ProductDto>> getTodayDeal(){
			
			List<ProductDto> p = productService.getTodayDeal();
			return new ResponseEntity<List<ProductDto>>(p, HttpStatus.OK);
			
		}
	
	
	//searching products based on product name
	@GetMapping(value="/{productname}/details")
	public ResponseEntity<List<ProductDto>> productDetails(@PathVariable("productname") String productName){
		//System.out.println("fetching: "+ productName);
		List<ProductDto> p = productService.getProductByProductName(productName);
		return new ResponseEntity<List<ProductDto>>(p, HttpStatus.OK);
		
	}
	
	//get individual product details 
	@GetMapping(value="/product/{productid}/{sellerid}")
	public ResponseEntity<ProductDto> getIndividualProductDetails(@PathVariable("productid") Integer productId,@PathVariable("sellerid") Integer sellerId ){
		ProductDto p = productService.getProductDetails(productId, sellerId);
		return new ResponseEntity<ProductDto>(p, HttpStatus.OK);
		
	}
	
	//get  products by seller 
		@GetMapping(value="/product/seller/{sellerid}")
		public ResponseEntity<List<ProductDto>> getProductBySeller(@PathVariable("sellerid") Integer sellerId ){
			List<ProductDto> p = productService.getProductBySeller(sellerId);
			return new ResponseEntity<List<ProductDto>>(p, HttpStatus.OK);
			
		}
	
	
	
	//adding product
	@PostMapping(value="/product")
	public ResponseEntity<ProductDto> addProductBySeller(@RequestBody ProductDto psd){
		ProductDto p = productService.addProduct(psd);
		return new ResponseEntity<ProductDto>(p, HttpStatus.OK);
	}
	
	//update product
	@PutMapping(value="/product")
	public ResponseEntity<ProductDto> updateProductBySeller(@RequestBody ProductDto psd){
		ProductDto p = productService.updateProduct(psd);
		return new ResponseEntity<ProductDto>(p, HttpStatus.OK);
	}
	
	//delete Product
	@RequestMapping(value="/product",method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteProductBySeller(@RequestBody ProductDto psd){
		Boolean p = productService.deleteProduct(psd);
		return new ResponseEntity<Boolean>(p, HttpStatus.OK);
	}
	
	//getting review of product
	@GetMapping(value="/product/{productid}/reviews")
	public ResponseEntity<List<ReviewDto>> getReviews(@PathVariable("productid") Integer productId){
		List<ReviewDto> revList = reviewService.getProductReviews(productId);
		return new ResponseEntity<List<ReviewDto>>(revList, HttpStatus.OK);
	}
	
	//adding reviews to the products
	@PostMapping(value="/product/review")
	public ResponseEntity<ReviewDto> getReviews(@RequestBody ReviewDto reviewDto){
		ReviewDto r = reviewService.addReview(reviewDto);
		return new ResponseEntity<ReviewDto>(r, HttpStatus.OK);
	}
	
}
