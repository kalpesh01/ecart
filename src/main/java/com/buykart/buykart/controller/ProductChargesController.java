package com.buykart.buykart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buykart.buykart.model.ProductCharges;
import com.buykart.buykart.payload.ProductChargesPayload;
import com.buykart.buykart.response.ApiResponse;
import com.buykart.buykart.response.Response;
import com.buykart.buykart.service.ProductChargesService;

@RestController
@RequestMapping("/api/product_charges")
public class ProductChargesController {

	@Autowired
	ProductChargesService productChargesService;
	
	@PostMapping("/add-product-charges")
	public ResponseEntity<?> createProductCharges(@RequestBody ProductChargesPayload productChargesPayload){
		ProductCharges productCharges = this.productChargesService.createProductCharges(productChargesPayload);
		if(productCharges != null) {
			return ResponseEntity.ok(new Response("Product charges added successfully",productCharges,true));
		}else {
			return ResponseEntity.ok(new ApiResponse("Failed To Save",false));
		}
	}
	
	@PutMapping("/update-product-charges/{Id}")
	public ResponseEntity<?> updateProductCharges(@RequestBody ProductChargesPayload productChargesPayload,@PathVariable Long Id){
		ProductCharges productCharges = this.productChargesService.updateProductCharges(productChargesPayload,Id);
		if(productCharges != null) {
			return ResponseEntity.ok(new Response("Product charges updated successfully",productCharges,true));
		}else {
			return ResponseEntity.ok(new ApiResponse("Failed To update",false));
		}
	} 
	
	@GetMapping("/get-product-charges/{Id}")
	public ResponseEntity<?> getProductCharges(@PathVariable Long Id){
		ProductCharges productCharges = this.productChargesService.getProductChargesById(Id);
		if(productCharges != null) {
			return ResponseEntity.ok(new Response("Product Charges fetched successfully",productCharges,true));
		}else {
			return ResponseEntity.ok(new ApiResponse("Failed To fetch",false));
		}
	} 
	
	@GetMapping("/get-product-charges")
	public ResponseEntity<?> getAllProductCharges(){
		List<ProductCharges> productCharges = this.productChargesService.getAllProductsCharges();
		if(productCharges != null) {
			return ResponseEntity.ok(new Response("Product Charges fetched successfully",productCharges,true));
		}else {
			return ResponseEntity.ok(new ApiResponse("Failed To fetch",false));
		}
	} 
	
	@DeleteMapping("/delete-product-charges/{Id}")
	public ResponseEntity<?> deleteProductCharges(@PathVariable Long Id){
		 boolean deleteProductCharges = this.productChargesService.deleteProductCharges(Id);
		if(deleteProductCharges) {
			return ResponseEntity.ok(new ApiResponse("Product Charges Deleted successfully",true));
		}else {
			return ResponseEntity.ok(new ApiResponse("Failed To fetch",false));
		}
	} 
}
