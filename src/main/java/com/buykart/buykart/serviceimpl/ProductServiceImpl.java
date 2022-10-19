package com.buykart.buykart.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buykart.buykart.beans.ProductChargesBean;
import com.buykart.buykart.model.Product;
import com.buykart.buykart.model.ProductCharges;
import com.buykart.buykart.payload.ProductPayload;
import com.buykart.buykart.repository.ProductRepository;
import com.buykart.buykart.response.ProductDetailResponse;
import com.buykart.buykart.service.ProductChargesService;
import com.buykart.buykart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductChargesService productChargesService;

	@Override
	public Product createProduct(ProductPayload productPayload) {
		if (productPayload.getProductChargesId() != null) {
			ProductCharges productCharges = this.productChargesService
					.getProductChargesById(productPayload.getProductChargesId());
			if (productCharges != null) {
				Product product = this.productPayloadToProduct(productPayload);
				product.setProductCharges(productCharges);
				Product savedProduct = this.productRepository.save(product);
				return savedProduct;
			}
			return null;

		}
		return null;
	}

	@Override
	public Product updateProduct(ProductPayload productPayload, Long Id) {
		
		if(productPayload.getProductChargesId() != null) {
			ProductCharges productCharges = this.productChargesService
					.getProductChargesById(productPayload.getProductChargesId());
			if(productCharges!=null) {
				Product product = this.productRepository.findById(Id).get();
				product.setProductId(productPayload.getProductId());
				product.setProductCategory(productPayload.getProductCategory());
				product.setProductName(productPayload.getProductName());
				product.setProductPrice(productPayload.getProductPrice());
				product.setProductType(productPayload.getProductType());
				product.setProductCharges(productCharges);
				Product savedProduct = this.productRepository.save(product);
				return savedProduct;
			}	
		}
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}

	@Override
	public Product getProductById(Long productId) {
		Optional<Product> findById = this.productRepository.findById(productId);
		return findById.get();
	}

	@Override
	public boolean deleteProduct(Long productId) {
		if (productId != null) {
			Optional<Product> findById = this.productRepository.findById(productId);
			if (findById.isPresent()) {
				Product product = findById.get();
				this.productRepository.delete(product);
				return true;
			}

		}
		return false;
	}

	private Product productPayloadToProduct(ProductPayload productPayload) {
		Product product = new Product();
		product.setProductId(productPayload.getProductId());
		product.setProductCategory(productPayload.getProductCategory());
		product.setProductName(productPayload.getProductName());
		product.setProductPrice(productPayload.getProductPrice());
		product.setProductType(productPayload.getProductType());

		return product;
	}

	
	@Override
	public List<ProductDetailResponse> getProducts() {
		List<Product> allProducts = this.productRepository.findAll();
		List<ProductDetailResponse> products = new ArrayList<ProductDetailResponse>();
		for(Product product : allProducts) {
			ProductDetailResponse productDetailResponse = new ProductDetailResponse();
			productDetailResponse.setProductId(product.getProductId());
			productDetailResponse.setName(product.getProductName());
			productDetailResponse.setProductType(product.getProductType());
			productDetailResponse.setCategory(product.getProductCategory());
			productDetailResponse.setBasePrice(product.getProductPrice());
			double productPrice = product.getProductPrice();
			double discount = (productPrice * product.getProductCharges().getDiscount())/100;

			double gst =  (productPrice * product.getProductCharges().getApplicableGST())/100;

			double delivery = product.getProductCharges().getDelivaryCharges();
			System.out.println("discount "+discount+" gst "+gst+" delivery "+delivery);
			double finalPirce = (productPrice - discount) +gst + delivery;
			productDetailResponse.setDiscount(discount);

			ProductChargesBean chargeBean = new ProductChargesBean();
			chargeBean.setGst(gst);
			chargeBean.setDelivery(delivery);
			productDetailResponse.setCharges(chargeBean);
			productDetailResponse.setFinalPrice(finalPirce);
			
			products.add(productDetailResponse);
		}
		
		
		return products;
	}
}
