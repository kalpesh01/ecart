package com.buykart.buykart.payload;

public class ProductPayload {
	
	private String productId;
	
	private String productName;
	
	private String productType;
	
	private String productCategory;
	
	private double productPrice;

	private Long productChargesId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Long getProductChargesId() {
		return productChargesId;
	}

	public void setProductChargesId(Long productChargesId) {
		this.productChargesId = productChargesId;
	}

}
