package com.buykart.buykart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductCharges {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chargeId;
	
	private String productCategory;
	
	private double discount;
	
	private double applicableGST;

	private double delivaryCharges;

	public Long getChargeId() {
		return chargeId;
	}

	public void setChargeId(Long chargeId) {
		this.chargeId = chargeId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getApplicableGST() {
		return applicableGST;
	}

	public void setApplicableGST(double applicableGST) {
		this.applicableGST = applicableGST;
	}

	public double getDelivaryCharges() {
		return delivaryCharges;
	}

	public void setDelivaryCharges(double delivaryCharges) {
		this.delivaryCharges = delivaryCharges;
	}

	@Override
	public String toString() {
		return "ProductCharges [chargeId=" + chargeId + ", productCategory=" + productCategory + ", discount="
				+ discount + ", applicableGST=" + applicableGST + ", delivaryCharges=" + delivaryCharges + "]";
	}
	
	
}
