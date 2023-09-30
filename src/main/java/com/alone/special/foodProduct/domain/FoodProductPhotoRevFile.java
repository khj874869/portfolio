package com.alone.special.foodProduct.domain;

public class FoodProductPhotoRevFile {
	private int refFProductRevId;
	private int fProductRevFileno;
	private String fProductRevFilename;
	private String fProductRevFilerename;
	private String fProductRevFilepath;
	public int getRefFProductRevId() {
		return refFProductRevId;
	}
	public void setRefFProductRevId(int refFProductRevId) {
		this.refFProductRevId = refFProductRevId;
	}
	public int getfProductRevFileno() {
		return fProductRevFileno;
	}
	public void setfProductRevFileno(int fProductRevFileno) {
		this.fProductRevFileno = fProductRevFileno;
	}
	public String getfProductRevFilename() {
		return fProductRevFilename;
	}
	public void setfProductRevFilename(String fProductRevFilename) {
		this.fProductRevFilename = fProductRevFilename;
	}
	public String getfProductRevFilerename() {
		return fProductRevFilerename;
	}
	public void setfProductRevFilerename(String fProductRevFilerename) {
		this.fProductRevFilerename = fProductRevFilerename;
	}
	public String getfProductRevFilepath() {
		return fProductRevFilepath;
	}
	public void setfProductRevFilepath(String fProductRevFilepath) {
		this.fProductRevFilepath = fProductRevFilepath;
	}
	@Override
	public String toString() {
		return "추천상품 포토리뷰 파일 [연관상품리뷰ID=" + refFProductRevId + ", 리뷰이미지NO="
				+ fProductRevFileno + ", 포토리뷰파일이름=" + fProductRevFilename + ", 포토리뷰파일리네임="
				+ fProductRevFilerename + ", 포토리뷰파일경로=" + fProductRevFilepath + "]";
	}
	
	
	
}
