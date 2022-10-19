package com.buykart.buykart.service;

import java.util.List;

import com.buykart.buykart.model.ProductCharges;
import com.buykart.buykart.payload.ProductChargesPayload;

public interface ProductChargesService {
	
	public ProductCharges createProductCharges(ProductChargesPayload productChargesPayload);
	
	public ProductCharges updateProductCharges(ProductChargesPayload productChargesPayload,Long Id);
	
	public List<ProductCharges> getAllProductsCharges();
	
	public ProductCharges getProductChargesById(Long productId);
	
	public boolean deleteProductCharges(Long productId);

}
