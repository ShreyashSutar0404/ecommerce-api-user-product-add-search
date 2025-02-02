package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.Product;
import org.dnyanyog.dto.User;

public class UserService {
	public List<String> getDetails(String userName){
		List<String> userList = new ArrayList<>();
		try {
			ResultSet rs = DBUtils.executeSelectQuery("select * from users where username = '"+userName+"' ");
			while(rs.next()) {
				userList.add("User Id :" + rs.getInt("id"));
				userList.add("User name :" + rs.getString("username"));
				userList.add("User Email :" + rs.getString("email"));
				userList.add("User Password :" + rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public String SaveData(User user) {
		System.out.println(user.id);
		System.out.println(user.username);
		System.out.println(user.email);
		System.out.println(user.password);
		
		try {
			DBUtils.executeUpdateQuery("INSERT INTO users (id, username, email, password) VALUES (" 
			        + user.id + ", '" + user.username + "', '" + user.email + "', '" + user.password + "')");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return "Data Saved";
	}


}


