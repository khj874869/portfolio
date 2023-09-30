package com.alone.special.foodProduct.domain;

import java.sql.Timestamp;

public class FoodProduct {
	
	private int fProductId;
	private String fProductName;
	private String fProductCompany;
	private int fProductPrice;
	private String fProductSimple;
	private String fProductDetail;
	private String fProductType;
	private String fProductInfo;
	private Timestamp fProductDate;
	public int getfProductId() {
		return fProductId;
	}
	public void setfProductId(int fProductId) {
		this.fProductId = fProductId;
	}
	public String getfProductName() {
		return fProductName;
	}
	public void setfProductName(String fProductName) {
		this.fProductName = fProductName;
	}
	public String getfProductCompany() {
		return fProductCompany;
	}
	public void setfProductCompany(String fProductCompany) {
		this.fProductCompany = fProductCompany;
	}
	public int getfProductPrice() {
		return fProductPrice;
	}
	public void setfProductPrice(int fProductPrice) {
		this.fProductPrice = fProductPrice;
	}
	public String getfProductSimple() {
		return fProductSimple;
	}
	public void setfProductSimple(String fProductSimple) {
		this.fProductSimple = fProductSimple;
	}
	public String getfProductDetail() {
		return fProductDetail;
	}
	public void setfProductDetail(String fProductDetail) {
		this.fProductDetail = fProductDetail;
	}
	public String getfProductType() {
		return fProductType;
	}
	public void setfProductType(String fProductType) {
		this.fProductType = fProductType;
	}
	public String getfProductInfo() {
		return fProductInfo;
	}
	public void setfProductInfo(String fProductInfo) {
		this.fProductInfo = fProductInfo;
	}
	public Timestamp getfProductDate() {
		return fProductDate;
	}
	public void setfProductDate(Timestamp fProductDate) {
		this.fProductDate = fProductDate;
	}
	@Override
	public String toString() {
		return "추천상품 [상품ID=" + fProductId + ", 상품명=" + fProductName + ", 기업명="
				+ fProductCompany + ", 상품가격=" + fProductPrice + ", 상품간단설명=" + fProductSimple
				+ ", 상품상세설명=" + fProductDetail + ", 상품종류=" + fProductType + ", 상품영양정보="
				+ fProductInfo + ", 상품등록일=" + fProductDate + "]";
	}
	
	
}
