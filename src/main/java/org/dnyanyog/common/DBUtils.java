package org.dnyanyog.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static String url = "jdbc:mysql://localhost:3306/e_commerce_db_3";
	private static String userName = "root";
	private static String password = "S@ngl!#10@";
	private static Connection connection;
	
	static {
		try {
			connection = DriverManager.getConnection(url,userName,password);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	
	public static ResultSet executeSelectQuery(String query) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		return result;
	}
	
	public static int executeUpdateQuery(String query) throws SQLException {
		Statement statement = connection.createStatement();
		return statement.executeUpdate(query);
		
	}
}
