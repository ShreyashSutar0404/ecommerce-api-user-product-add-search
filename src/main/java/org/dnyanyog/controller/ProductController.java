package org.dnyanyog.controller;

import java.sql.SQLException;
import java.util.List;

import org.dnyanyog.dto.Product;
import org.dnyanyog.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecommerce")

public class ProductController {
	
	@GetMapping("/product/{productName}")
	public List<String> getDetails(@PathVariable String productName){
		return new ProductService().getDetails(productName);
	}
	
	@PostMapping(path= "/product",  produces= {"application/json"}, consumes= {"application/json"})
	public String saveProductData(@RequestBody Product product) throws SQLException {
		return new ProductService().SaveData(product);
		
	}}
