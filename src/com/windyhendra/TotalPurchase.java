package com.windyhendra;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "totalpurchase")
public class TotalPurchase {
	int totalPurchase = 0;
	
	public TotalPurchase(){}
	
	public TotalPurchase(int total) {
		this.totalPurchase = total;
	}
	
	@XmlElement
	public void setTotal(int total) {
		this.totalPurchase = total;
	}
	
	public int getTotal() {
		return totalPurchase;
	}
}
