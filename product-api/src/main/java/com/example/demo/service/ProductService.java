package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {

	private ProductRepo productRepo;

	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	public Product getProductById(Long id) {
		return this.productRepo.findById(id).orElse(null);
	}

	public void addProduct(Product product) {
		this.productRepo.save(product);
	}

	public void removeProductById(Long id) {
		if (getProductById(id) == null) {
			System.out.println("Product not found");
			return;
		}
		this.productRepo.deleteById(id);
	}

	public void updateProduct(Product product) {
		this.productRepo.save(product);
	}

}
