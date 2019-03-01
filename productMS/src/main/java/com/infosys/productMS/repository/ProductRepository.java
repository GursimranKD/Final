package com.infosys.productMS.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infosys.productMS.domain.Product;
import com.infosys.productMS.domain.ProductIds;

public interface ProductRepository extends JpaRepository<Product, ProductIds>{
	
	
	public List<Product> findByDisplayNameIgnoreCaseContaining(String productName);
	
	public List<Product> findByProductIdsSellerId(Integer sellerId);
	
	public Product findByProductIds(ProductIds pids);
	
	@Query("select max(p.productIds.productId) from Product p")
	public Integer getMaxProductId();
	
	@Query("select  p from Product p order by (p.discount + p.offerPrice) / p.price desc")
	public List<Product> getTodayDeal(Pageable pageable);
	
	
	

}
