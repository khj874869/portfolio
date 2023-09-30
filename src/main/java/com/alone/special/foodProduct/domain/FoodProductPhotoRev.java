package com.alone.special.foodProduct.domain;

import java.sql.Timestamp;

public class FoodProductPhotoRev {
	private int fProductRevId;
	private String fUserId;
	private String fProductRevTitle;
	private String fProductRevContent;
	private float fProductRevStar;
	private Timestamp fProductRevCDate;
	private Timestamp fProductRevUDate;
	private int refFProductId;

	public int getfProductRevId() {
		return fProductRevId;
	}
	public void setfProductRevId(int fProductRevId) {
		this.fProductRevId = fProductRevId;
	}
	public String getfUserId() {
		return fUserId;
	}
	public void setfUserId(String fUserId) {
		this.fUserId = fUserId;
	}
	public String getfProductRevTitle() {
		return fProductRevTitle;
	}
	public void setfProductRevTitle(String fProductRevTitle) {
		this.fProductRevTitle = fProductRevTitle;
	}
	public String getfProductRevContent() {
		return fProductRevContent;
	}
	public void setfProductRevContent(String fProductRevContent) {
		this.fProductRevContent = fProductRevContent;
	}
	public float getfProductRevStar() {
		return fProductRevStar;
	}
	public void setfProductRevStar(float fProductRevStar) {
		this.fProductRevStar = fProductRevStar;
	}
	public Timestamp getfProductRevCDate() {
		return fProductRevCDate;
	}
	public void setfProductRevCDate(Timestamp fProductRevCDate) {
		this.fProductRevCDate = fProductRevCDate;
	}
	public Timestamp getfProductRevUDate() {
		return fProductRevUDate;
	}
	public void setfProductRevUDate(Timestamp fProductRevUDate) {
		this.fProductRevUDate = fProductRevUDate;
	}
	public int getRefFProductId() {
		return refFProductId;
	}
	public void setRefFProductId(int refFProductId) {
		this.refFProductId = refFProductId;
	}

	@Override
	public String toString() {
		return "추천상품포토리뷰 [포토리뷰ID=" + fProductRevId + ", 사용자ID=" + fUserId + ", 리뷰제목="
				+ fProductRevTitle + ", 리뷰내용=" + fProductRevContent + ", 리뷰별점="
				+ fProductRevStar + ", 리뷰생성일=" + fProductRevCDate + ", 리뷰수정일=" + fProductRevUDate
				+ ", 연관상품ID=" + refFProductId  + "]";
	}
	
	
}
