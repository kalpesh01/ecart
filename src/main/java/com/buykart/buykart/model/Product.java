package com.buykart.buykart.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String productId;
	
	private String productName;
	
	private String productType;
	
	private String productCategory;
	
	private double productPrice;
	
	@OneToOne(targetEntity = ProductCharges.class)
	@JoinColumn(name = "productCharges")
	private ProductCharges productCharges;

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

	public ProductCharges getProductCharges() {
		return productCharges;
	}

	public void setProductCharges(ProductCharges productCharges) {
		this.productCharges = productCharges;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", productName=" + productName + ", productType="
				+ productType + ", productCategory=" + productCategory + ", productPrice=" + productPrice
				+ ", productCharges=" + productCharges + "]";
	}
	
	
	
}
