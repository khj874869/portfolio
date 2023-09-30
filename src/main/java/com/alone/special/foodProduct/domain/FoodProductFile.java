package com.alone.special.foodProduct.domain;

public class FoodProductFile {
	private int refFProductId;
	private int fProductFileorder;
	private String fProductFilename;
	private String fProductFilerename;
	private String fProductFilepath;
	public int getRefFProductId() {
		return refFProductId;
	}
	public void setRefFProductId(int refFProductId) {
		this.refFProductId = refFProductId;
	}
	public int getfProductFileorder() {
		return fProductFileorder;
	}
	public void setfProductFileorder(int fProductFileorder) {
		this.fProductFileorder = fProductFileorder;
	}
	public String getfProductFilename() {
		return fProductFilename;
	}
	public void setfProductFilename(String fProductFilename) {
		this.fProductFilename = fProductFilename;
	}
	public String getfProductFilerename() {
		return fProductFilerename;
	}
	public void setfProductFilerename(String fProductFilerename) {
		this.fProductFilerename = fProductFilerename;
	}
	public String getfProductFilepath() {
		return fProductFilepath;
	}
	public void setfProductFilepath(String fProductFilepath) {
		this.fProductFilepath = fProductFilepath;
	}
	@Override
	public String toString() {
		return "추천상품파일 [연관상품ID=" + refFProductId + ", 파일순서=" + fProductFileorder
				+ ", 파일이름=" + fProductFilename + ", 파일리네임=" + fProductFilerename
				+ ", 파일경로=" + fProductFilepath + "]";
	}
	
	
}
