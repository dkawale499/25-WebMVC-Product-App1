package com.sts.service;

import java.util.List;

import com.sts.entity.Product;

public interface ProductService {

	public boolean saveproduct(Product p);
	
	public List<Product>getAllProducts();
	
	
	
}
