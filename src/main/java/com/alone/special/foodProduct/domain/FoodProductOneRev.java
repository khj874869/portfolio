package com.alone.special.foodProduct.domain;

import java.sql.Timestamp;

public class FoodProductOneRev {
	private String fProductOneRevWriter;
	private int fProductOneRevNo;
	private String fProductOneRevContent;
	private float fProductOneRevStar;
	private Timestamp fProductOneRevCDate;
	private Timestamp fProductOneRevUDate;
	private int refFProductId;

	public String getfProductOneRevWriter() {
		return fProductOneRevWriter;
	}
	public void setfProductOneRevWriter(String fProductOneRevWriter) {
		this.fProductOneRevWriter = fProductOneRevWriter;
	}
	public int getfProductOneRevNo() {
		return fProductOneRevNo;
	}
	public void setfProductOneRevNo(int fProductOneRevNo) {
		this.fProductOneRevNo = fProductOneRevNo;
	}
	public String getfProductOneRevContent() {
		return fProductOneRevContent;
	}
	public void setfProductOneRevContent(String fProductOneRevContent) {
		this.fProductOneRevContent = fProductOneRevContent;
	}
	public float getfProductOneRevStar() {
		return fProductOneRevStar;
	}
	public void setfProductOneRevStar(float fProductOneRevStar) {
		this.fProductOneRevStar = fProductOneRevStar;
	}
	public Timestamp getfProductOneRevCDate() {
		return fProductOneRevCDate;
	}
	public void setfProductOneRevCDate(Timestamp fProductOneRevCDate) {
		this.fProductOneRevCDate = fProductOneRevCDate;
	}
	public Timestamp getfProductOneRevUDate() {
		return fProductOneRevUDate;
	}
	public void setfProductOneRevUDate(Timestamp fProductOneRevUDate) {
		this.fProductOneRevUDate = fProductOneRevUDate;
	}
	public int getRefFProductId() {
		return refFProductId;
	}
	public void setRefFProductId(int refFProductId) {
		this.refFProductId = refFProductId;
	}

	@Override
	public String toString() {
		return "추천상품한줄리뷰 [한줄리뷰작성자=" + fProductOneRevWriter + ", 한줄리뷰번호=" + fProductOneRevNo
				+ ", 한줄리뷰내용=" + fProductOneRevContent + ", 한줄리뷰별점=" + fProductOneRevStar
				+ ", 한줄리뷰생성일=" + fProductOneRevCDate + ", 한줄리뷰수정일=" + fProductOneRevUDate
				+ ", 연관상품ID=" + refFProductId  + "]";
	}
	
	
}
