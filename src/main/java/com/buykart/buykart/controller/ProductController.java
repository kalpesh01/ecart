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

import com.buykart.buykart.model.Product;
import com.buykart.buykart.payload.ProductPayload;
import com.buykart.buykart.response.ApiResponse;
import com.buykart.buykart.response.ProductDetailResponse;
import com.buykart.buykart.response.Response;
import com.buykart.buykart.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping("/save-product")
	public ResponseEntity<?> createProduct(@RequestBody ProductPayload productPayload){
		Product createProduct = productService.createProduct(productPayload);
		
		if(createProduct != null) {
			return ResponseEntity.ok(new Response("product Saved Successfully",createProduct,true));
		}else {
			return ResponseEntity.ok(new ApiResponse("Failed To Save",false));
		}
	}
	
	@PutMapping("/update-product/{Id}")
	public ResponseEntity<?> updateProductCharges(@RequestBody ProductPayload productPayload,@PathVariable Long Id){
		Product product = this.productService.updateProduct(productPayload,Id);
		if(product != null ) {
			return ResponseEntity.ok(new Response("Product updated successfully",product,true));
		}else {
			return ResponseEntity.ok(new ApiResponse("Failed To update",false));
		}
	}
	
	@GetMapping("/get-product/{Id}")
	public ResponseEntity<?> getProductCharges(@PathVariable Long Id){
		Product product = this.productService.getProductById(Id);
		if(product != null) {
			return ResponseEntity.ok(new Response("Product fetched successfully",product,true));
		}else {
			return ResponseEntity.ok(new ApiResponse("Failed To fetch",false));
		}
	} 
	
	@GetMapping("/get-all-product")
	public ResponseEntity<?> getAllProductCharges(){
		List<Product> products = this.productService.getAllProducts();

		if(!products.isEmpty()) {
			return ResponseEntity.ok(new Response("All Product fetched successfully",products,true));
		}else {
			return ResponseEntity.ok(new ApiResponse("Failed To fetch",false));
		}
	} 
	
	@DeleteMapping("/delete-product/{Id}")
	public ResponseEntity<?> deleteProductCharges(@PathVariable Long Id){
		 boolean deleteProduct = this.productService.deleteProduct(Id);
		if(deleteProduct) {
			return ResponseEntity.ok(new ApiResponse("Product Charges Deleted successfully",true));
		}else {
			return ResponseEntity.ok(new ApiResponse("Failed To fetch",false));
		}
	} 
	
	@GetMapping("/get-products")
	public ResponseEntity<?> getProducts(){
		List<ProductDetailResponse> products = this.productService.getProducts();

		if(!products.isEmpty()) {
			return ResponseEntity.ok(new Response("Products fetched successfully",products,true));
		}else {
			return ResponseEntity.ok(new ApiResponse("Failed To fetch",false));
		}
	}
	
}
