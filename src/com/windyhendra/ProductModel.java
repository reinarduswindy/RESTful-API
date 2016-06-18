package com.windyhendra;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductModel {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.12.59.2:3306/restapi";
	static final String username = "admin1mZE6Qq";
	static final String password = "eEl-WqBYKLEI";
	
//	static final String DB_URL = "jdbc:mysql://localhost/salestock_test";
//	static final String username = "root";
//	static final String password = "";
	
	Connection conn;
	String sql;
	
	public ProductModel() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, username, password);			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Product getProduct(String id) {
		sql = "SELECT * FROM products WHERE id='" + id + "'";
		
		Product pro = new Product();
		
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				pro.id = res.getString("id");
				pro.name = res.getString("name");
				pro.price = res.getInt("price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pro;
	}
	
	@XmlElement
	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		
		sql = "SELECT * FROM products";
		
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				String id = res.getString("id");
				String name = res.getString("name");
				int price = res.getInt("price");
				
				Product pro = new Product(id, name, price);
				productList.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList;
	}
}
