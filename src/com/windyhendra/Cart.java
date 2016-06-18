package com.windyhendra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cart implements Serializable {
	@XmlElement
	List<Product> productList = null;
	@XmlElement
	ProductModel pm = null;
	@XmlElement
	CouponModel cm = null;
	
	CartModel cam = null;
	
	@XmlElement
	Integer totalPurchase = new Integer(0);
	Coupon coupon = null;
	
	public Cart() {
		cam = new CartModel();
		pm = new ProductModel();
		cm = new CouponModel();
		productList = new ArrayList<Product>();
	}
	
	public Cart(Product pro, Coupon cou) {
		productList.add(pro);
		totalPurchase += pro.price;
		if(coupon == null) {
			coupon = cou;
		}
	}
	
	public Cart(Coupon cou, Product pro) {
		productList.add(pro);
		totalPurchase += pro.price;
		if(coupon == null) {
			coupon = cou;
		}
	}
	
	public Cart(Product pro) {
		productList.add(pro);
		totalPurchase += pro.price;
	}
	
	public void setCoupon(Coupon cou) {
		if(coupon == null) {
			coupon = cou;
		}
	}
	
	public void removeCoupon() {
		coupon = null;
		System.out.println("Berhasil menghapus kupon");
	}
	
	public void addProduct(String productId) {
		cam.addProduct(productId);
		System.out.println("Berhasil menambah produk ke dalam cart");
	}
	
	public void addCoupon(String couponId) {
		Coupon cou = cm.getCoupon(couponId);
		
		if(cou != null) {
			coupon = cou;
			
			System.out.println("Berhasil menambah kupon");
		}
	}
	
	public void removeProduct(String id) {
		for(int i=0; i<productList.size(); i++) {
			Product pro = productList.get(i);
			totalPurchase -= pro.price;
			if(pro.id == id) {
				productList.remove(i);
				
				System.out.println("Berhasil menghapus produk");
				return;
			}
		}
	}
	
	@XmlElement
	public List<Product> getAllProducts() {
		List<Product> pl = new ArrayList<Product>();
		pl = cam.getAllProducts();
		return pl;
	}
	
	@XmlElement
	public TotalPurchase getTotalPurchase() {
		TotalPurchase total = cam.getTotalPurchase();
		return total;
	}
}