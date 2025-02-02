package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.Product;

public class ProductService {
	//Get Details by adding Product Name in URL
	public List<String> getDetails(String productName){
		List<String> productList = new ArrayList<>();
		try {
			ResultSet rs = DBUtils.executeSelectQuery("select * from products where name = '"+productName+"' ");
			while(rs.next()) {
				productList.add("Id :" + rs.getInt("id"));
				productList.add("product name :" + rs.getString("name"));
				productList.add("product Quantity :" + rs.getString("price"));
				productList.add("product Price :" + rs.getString("quantity"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
		
	}
	
	public String SaveData(Product product) {
		System.out.println(product.id);
		System.out.println(product.name);
		System.out.println(product.quantity);
		System.out.println(product.price);
		try {
		DBUtils.executeUpdateQuery("INSERT INTO products (id, name, price, quantity) VALUES (" 
                + product.id + ", '" + product.name + "', " + product.price + ", " + product.quantity + ")");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "Data Saved";
		
	}

}
