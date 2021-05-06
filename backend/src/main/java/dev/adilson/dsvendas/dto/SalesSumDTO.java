package dev.adilson.dsvendas.dto;

import java.io.Serializable;

import dev.adilson.dsvendas.entities.Seller;

public class SalesSumDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sellerName;
	private Double sum;
	
	public SalesSumDTO() {}

	public SalesSumDTO(Seller seller, Double sum) {
		this.sellerName = seller.getname();
		this.sum = sum;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
	
	
}
