package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable Long id) {
		return this.productService.getProductById(id);
	}

	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		this.productService.addProduct(product);
		return product;
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		this.productService.removeProductById(id);
	}

	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		this.productService.updateProduct(product);
		return product;
	}

}
