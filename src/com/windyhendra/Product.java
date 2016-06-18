package com.windyhendra;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product {
	@XmlElement
	String id;
	@XmlElement
	String name;
	@XmlElement
	int price;
	
	public Product(){}
	
	public Product(String id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
