package com.buykart.buykart.payload;

public class ProductChargesPayload {
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
	
		
}
