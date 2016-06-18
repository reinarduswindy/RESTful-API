package com.windyhendra;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class CouponModel {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.12.59.2:3306/restapi";
	static final String username = "admin1mZE6Qq";
	static final String password = "eEl-WqBYKLEI";
	
//	static final String DB_URL = "jdbc:mysql://localhost/salestock_test";
//	static final String username = "root";
//	static final String password = "";
	
	Connection conn;
	String sql;
	
	public CouponModel() {
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
	
	public Coupon getCoupon(String code) {
		sql = "SELECT * FROM coupons WHERE code='" + code + "'";
		
		Coupon cou = new Coupon();
		
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				cou.id = res.getString("id");
				cou.code = res.getString("code");
				cou.nominal = res.getInt("nominal");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cou;
	}
	
	public List<Coupon> getAllCoupons() {
		List<Coupon> couponList = new ArrayList<Coupon>();
		
		sql = "SELECT * FROM coupons";
		
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				String id = res.getString("id");
				String code = res.getString("code");
				int nominal = res.getInt("nominal");
				
				Coupon cou = new Coupon(id, code, nominal);
				couponList.add(cou);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return couponList;
	}
}
