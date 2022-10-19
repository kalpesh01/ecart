package com.buykart.buykart.service;

import java.util.List;

import com.buykart.buykart.model.Product;
import com.buykart.buykart.payload.ProductPayload;
import com.buykart.buykart.response.ProductDetailResponse;

public interface ProductService {
	
	public Product createProduct(ProductPayload productPayload);
	
	public Product updateProduct(ProductPayload productPayload,Long Id);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Long productId);
	
	public boolean deleteProduct(Long productId);
	
	public List<ProductDetailResponse> getProducts();
		
}
