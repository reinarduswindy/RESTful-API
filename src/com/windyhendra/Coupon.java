package com.windyhendra;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coupon")
public class Coupon {
	@XmlElement
	String id;
	@XmlElement
	String code;
	@XmlElement
	int nominal;
	
	public Coupon(){}
	
	public Coupon(String id, String code, int nominal) {
		this.id = id;
		this.code = code;
		this.nominal = nominal;
	}
}
