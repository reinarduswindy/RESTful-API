package com.windyhendra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartModel {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/salestock_test";
	
	static final String username = "root";
	static final String password = "";
	
	Connection conn;
	String sql;
	
	public CartModel() {
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
	
	public void addProduct(String productId) {
		sql = "INSERT INTO cart_products VALUES(null, '" + productId + "')";
		
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		
		sql = "SELECT * FROM cart_products";
		
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			
			List<String> products = new ArrayList<String>();
			while(res.next()) {
				String product_id = res.getString("product_id");
				products.add(product_id);
			}
			
			for(int i=0; i<products.size(); i++) {
				sql = "SELECT * FROM products WHERE id='" + products.get(i) + "'";
				ResultSet res2 = st.executeQuery(sql);
				
				while(res2.next()) {
					String id = res2.getString("id");
					String name = res2.getString("name");
					int price = res2.getInt("price");
					
					Product pr = new Product(id, name, price);
					productList.add(pr);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList;
	}
	
	public TotalPurchase getTotalPurchase() {
		int total = 0;
		
		sql = "SELECT * FROM cart_products";
		
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			
			List<String> products = new ArrayList<String>();
			while(res.next()) {
				String product_id = res.getString("product_id");
				products.add(product_id);
			}
			
			for(int i=0; i<products.size(); i++) {
				sql = "SELECT * FROM products WHERE id='" + products.get(i) + "'";
				ResultSet res2 = st.executeQuery(sql);
				
				while(res2.next()) {
					int price = res2.getInt("price");
					
					total += price;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		TotalPurchase tpur = new TotalPurchase(total);
		
		return tpur;
	}
}
