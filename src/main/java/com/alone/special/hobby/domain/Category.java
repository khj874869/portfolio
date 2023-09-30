package com.alone.special.hobby.domain;

import java.sql.Timestamp;

public class Category {

	private String hCategoryName;
	private String hCategoryTag;
	private Timestamp hCategoryCreateDate;
	private char hCategoryStatus;
	private String hCategoryFilename;
	private String hCategoryFilepath;
	private long hCategoryFilelength;
	
	public String gethCategoryName() {
		return hCategoryName;
	}
	public void sethCategoryName(String hCategoryName) {
		this.hCategoryName = hCategoryName;
	}
	public String gethCategoryTag() {
		return hCategoryTag;
	}
	public void sethCategoryTag(String hCategoryTag) {
		this.hCategoryTag = hCategoryTag;
	}
	public Timestamp gethCategoryCreateDate() {
		return hCategoryCreateDate;
	}
	public void sethCategoryCreateDate(Timestamp hCategoryCreateDate) {
		this.hCategoryCreateDate = hCategoryCreateDate;
	}
	public char gethCategoryStatus() {
		return hCategoryStatus;
	}
	public void sethCategoryStatus(char hCategoryStatus) {
		this.hCategoryStatus = hCategoryStatus;
	}
	public String gethCategoryFilename() {
		return hCategoryFilename;
	}
	public void sethCategoryFilename(String hCategoryFilename) {
		this.hCategoryFilename = hCategoryFilename;
	}
	public String gethCategoryFilepath() {
		return hCategoryFilepath;
	}
	public void sethCategoryFilepath(String hCategoryFilepath) {
		this.hCategoryFilepath = hCategoryFilepath;
	}
	public long gethCategoryFilelength() {
		return hCategoryFilelength;
	}
	public void sethCategoryFilelength(long hCategoryFilelength) {
		this.hCategoryFilelength = hCategoryFilelength;
	}
	
	@Override
	public String toString() {
		return "취미 목록 [취미 목록 이름=" + hCategoryName + ", 취미 목록 태그=" + hCategoryTag + ", 취미 목록 생성일="
				+ hCategoryCreateDate + ", 취미 목록 상태=" + hCategoryStatus + ", 취미 목록 파일이름="
				+ hCategoryFilename + ", 취미 목록 파일경로=" + hCategoryFilepath + ", 취미 목록 파일길이="
				+ hCategoryFilelength + "]";
	}
	
}
