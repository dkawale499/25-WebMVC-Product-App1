package com.sts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.entity.Product;
import com.sts.repo.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo ProductRepo;
	
	@Override
	public boolean saveproduct(Product p) {
		// TODO Auto-generated method stub
		
		Product savedProduct = ProductRepo.save(p);
		
		return savedProduct.getPid()!=null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return ProductRepo.findAll();
	}

}
