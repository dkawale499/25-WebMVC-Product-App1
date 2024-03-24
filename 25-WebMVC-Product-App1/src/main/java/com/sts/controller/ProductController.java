package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.sts.entity.Product;
import com.sts.service.ProductService;


@Controller
public class ProductController {
	@Autowired
	private ProductService productservice;
	
	//Load From- get
	@GetMapping("/")
	public ModelAndView loadForm() {
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("pobj",new Product());  //form bindding
		mav.setViewName("index");
		
		return mav;
	}
	
	//saveproduct -post
	@PostMapping("/Product")
	public  ModelAndView saveProduct(Product pobj) {
		ModelAndView mav= new ModelAndView();
		
	boolean status =	productservice.saveproduct(pobj);
	if(status) {
		mav.addObject("smsg", "Product saved");
	}	else
	{
		mav.addObject("emsg", "Faied to save");

	}
		mav.addObject("pobj",new Product());  //form bindding
		mav.setViewName("index");
		return mav;	
	}
	
	//getprpductt -get
	@GetMapping("/products")
	public  ModelAndView viewProducts() {
		List<Product> productsList = productservice.getAllProducts();
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("plist", productsList);
		mav.setViewName("data");
		
		return mav;
	}
	
	
}
