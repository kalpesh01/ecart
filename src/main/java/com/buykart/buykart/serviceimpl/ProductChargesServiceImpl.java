package com.buykart.buykart.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buykart.buykart.model.ProductCharges;
import com.buykart.buykart.payload.ProductChargesPayload;
import com.buykart.buykart.repository.ProductChargesRepository;
import com.buykart.buykart.service.ProductChargesService;

@Service
public class ProductChargesServiceImpl implements ProductChargesService {

	@Autowired
	ProductChargesRepository productChargesRepository;

	@Override
	public ProductCharges createProductCharges(ProductChargesPayload productChargesPayload) {
		ProductCharges productCharges = this.productChargesRepository
				.save(this.productChargesPayloadToProctCharges(productChargesPayload));
		return productCharges;
	}

	@Override
	public ProductCharges updateProductCharges(ProductChargesPayload productChargesPayload, Long Id) {
		ProductCharges productCharges = this.productChargesRepository.findById(Id).get();

		productCharges.setProductCategory(productChargesPayload.getProductCategory());
		productCharges.setDiscount(productChargesPayload.getDiscount());
		productCharges.setApplicableGST(productChargesPayload.getApplicableGST());
		productCharges.setDelivaryCharges(productChargesPayload.getDelivaryCharges());

		ProductCharges savedProductCharges = this.productChargesRepository.save(productCharges);

		return savedProductCharges;
	}

	@Override
	public List<ProductCharges> getAllProductsCharges() {
		return this.productChargesRepository.findAll();
	}

	@Override
	public ProductCharges getProductChargesById(Long productId) {
		return this.productChargesRepository.findById(productId).get();
	}

	@Override
	public boolean deleteProductCharges(Long productId) {
		if (productId != null) {
			ProductCharges productCharges = this.productChargesRepository.findById(productId).get();
			if (productCharges != null) {
				this.productChargesRepository.delete(productCharges);
				return true;
			}
		}
		return false;

	}

	private ProductCharges productChargesPayloadToProctCharges(ProductChargesPayload productChargesPayload) {
		ProductCharges productCharges = new ProductCharges();
		productCharges.setProductCategory(productChargesPayload.getProductCategory());
		productCharges.setDiscount(productChargesPayload.getDiscount());
		productCharges.setApplicableGST(productChargesPayload.getApplicableGST());
		productCharges.setDelivaryCharges(productChargesPayload.getDelivaryCharges());
		return productCharges;
	}
}
