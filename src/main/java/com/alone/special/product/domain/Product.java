package com.alone.special.product.domain;

public class Product {
	private int sProductId;
	private String sProductName;
	private String sFileName;
	private String sFileReName;
	private String sFilePath;
	private long sFileLength;
	private String sDescription;
	private Integer sPrice;
	private double sProductAverageRating;	
	public int getsProductId() {
		return sProductId;
	}
	public void setsProductId(int sProductId) {
		this.sProductId = sProductId;
	}
	public String getsProductName() {
		return sProductName;
	}
	
	public String getsFileName() {
		return sFileName;
	}
	public void setsFileName(String sFileName) {
		this.sFileName = sFileName;
	}
	public String getsFileReName() {
		return sFileReName;
	}
	public void setsFileReName(String sFileReName) {
		this.sFileReName = sFileReName;
	}
	public String getsFilePath() {
		return sFilePath;
	}
	public void setsFilePath(String sFilePath) {
		this.sFilePath = sFilePath;
	}
	public long  getsFileLength() {
		return sFileLength;
	}
	public void setsFileLength(long sFileLength) {
		this.sFileLength = sFileLength;
	}
	public void setsProductName(String sProductName) {
		this.sProductName = sProductName;
	}
	public String getsDescription() {
		return sDescription;
	}
	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}
	public Integer getsPrice() {
		return sPrice;
	}
	public void setsPrice(Integer sPrice) {
		this.sPrice = sPrice;
	}
	public double getsProductAverageRating() {
		return sProductAverageRating;
	}
	public void setsProductAverageRating(double sProductAverageRating) {
		this.sProductAverageRating = sProductAverageRating;
	}
	@Override
	public String toString() {
		return "Product [상품번호=" + sProductId + ", 상품이름=" + sProductName + ", 상품이미지이름=" + sFileName
				+ ", 상품이미지수정=" + sFileReName + ", 상품이미지경로=" + sFilePath + ", 상품이미지길이=" + sFileLength
				+ ", 상품설명=" + sDescription + ", 상품가격=" + sPrice + ", 상품평점평균="
				+ sProductAverageRating + "]";
	}

	
}
