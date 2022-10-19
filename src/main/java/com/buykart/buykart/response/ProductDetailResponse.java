package com.buykart.buykart.response;

import com.buykart.buykart.beans.ProductChargesBean;

public class ProductDetailResponse {

	private String productId;
	private String name;
	private String productType;
	private String	category;
	private double basePrice;
	private double discount;
	private double finalPrice;
	
	private ProductChargesBean charges;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public ProductChargesBean getCharges() {
		return charges;
	}

	public void setCharges(ProductChargesBean charges) {
		this.charges = charges;
	}
	
	
}
