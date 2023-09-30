package com.alone.special.hobby.domain;

import java.sql.Timestamp;

public class Board {

	private int hBoardNo;
	private String refCategoryName;
	private String hBoardCategory;
	private String hBoardWriter;
	private String hBoardTitle;
	private String hBoardContent;
	private int hBoardReplyNum;
	private Timestamp hGroupTime;
	private String hGroupPlace;
	private int hGroupPersonNum;
	private String hGroupApplyPerson;
	private int hGroupApplyPersonNum;
	private Timestamp hBoardCreateDate;
	private Timestamp hBoardUpdateDate;
	private char hBoardStatus;
	private String hBoardFilename;
	private String hBoardFilerename;
	private String hBoardFilepath;
	private long hBoardFilelength;
	
	public int gethBoardNo() {
		return hBoardNo;
	}
	public void sethBoardNo(int hBoardNo) {
		this.hBoardNo = hBoardNo;
	}
	public String getRefCategoryName() {
		return refCategoryName;
	}
	public void setRefCategoryName(String refCategoryName) {
		this.refCategoryName = refCategoryName;
	}
	public String gethBoardCategory() {
		return hBoardCategory;
	}
	public void sethBoardCategory(String hBoardCategory) {
		this.hBoardCategory = hBoardCategory;
	}
	public String gethBoardWriter() {
		return hBoardWriter;
	}
	public void sethBoardWriter(String hBoardWriter) {
		this.hBoardWriter = hBoardWriter;
	}
	public String gethBoardTitle() {
		return hBoardTitle;
	}
	public void sethBoardTitle(String hBoardTitle) {
		this.hBoardTitle = hBoardTitle;
	}
	public String gethBoardContent() {
		return hBoardContent;
	}
	public void sethBoardContent(String hBoardContent) {
		this.hBoardContent = hBoardContent;
	}
	public int gethBoardReplyNum() {
		return hBoardReplyNum;
	}
	public void sethBoardReplyNum(int hBoardReplyNum) {
		this.hBoardReplyNum = hBoardReplyNum;
	}
	public Timestamp gethGroupTime() {
		return hGroupTime;
	}
	public void sethGroupTime(Timestamp hGroupTime) {
		this.hGroupTime = hGroupTime;
	}
	public String gethGroupPlace() {
		return hGroupPlace;
	}
	public void sethGroupPlace(String hGroupPlace) {
		this.hGroupPlace = hGroupPlace;
	}
	public int gethGroupPersonNum() {
		return hGroupPersonNum;
	}
	public void sethGroupPersonNum(int hGroupPersonNum) {
		this.hGroupPersonNum = hGroupPersonNum;
	}
	public String gethGroupApplyPerson() {
		return hGroupApplyPerson;
	}
	public void sethGroupApplyPerson(String hGroupApplyPerson) {
		this.hGroupApplyPerson = hGroupApplyPerson;
	}
	public int gethGroupApplyPersonNum() {
		return hGroupApplyPersonNum;
	}
	public void sethGroupApplyPersonNum(int hGroupApplyPersonNum) {
		this.hGroupApplyPersonNum = hGroupApplyPersonNum;
	}
	public Timestamp gethBoardCreateDate() {
		return hBoardCreateDate;
	}
	public void sethBoardCreateDate(Timestamp hBoardCreateDate) {
		this.hBoardCreateDate = hBoardCreateDate;
	}
	public Timestamp gethBoardUpdateDate() {
		return hBoardUpdateDate;
	}
	public void sethBoardUpdateDate(Timestamp hBoardUpdateDate) {
		this.hBoardUpdateDate = hBoardUpdateDate;
	}
	public char gethBoardStatus() {
		return hBoardStatus;
	}
	public void sethBoardStatus(char hBoardStatus) {
		this.hBoardStatus = hBoardStatus;
	}
	public String gethBoardFilename() {
		return hBoardFilename;
	}
	public void sethBoardFilename(String hBoardFilename) {
		this.hBoardFilename = hBoardFilename;
	}
	public String gethBoardFilerename() {
		return hBoardFilerename;
	}
	public void sethBoardFilerename(String hBoardFilerename) {
		this.hBoardFilerename = hBoardFilerename;
	}
	public String gethBoardFilepath() {
		return hBoardFilepath;
	}
	public void sethBoardFilepath(String hBoardFilepath) {
		this.hBoardFilepath = hBoardFilepath;
	}
	public long gethBoardFilelength() {
		return hBoardFilelength;
	}
	public void sethBoardFilelength(long hBoardFilelength) {
		this.hBoardFilelength = hBoardFilelength;
	}
	
	@Override
	public String toString() {
		return "취미 게시글 [취미 게시글 번호=" + hBoardNo + ", 참고 게시글 이름=" + refCategoryName + ", 참고 게시글 분류="
				+ hBoardCategory + ", 취미 게시글 작성자=" + hBoardWriter + ", 취미 게시글 제목=" + hBoardTitle
				+ ", 취미 게시글 내용=" + hBoardContent + ", 취미 게시글 댓글수=" + hBoardReplyNum + ", 취미 게시글 소모임 일정="
				+ hGroupTime + ", 취미 게시글 소모임 장소=" + hGroupPlace + ", 취미 게시글 소모임 모집인원수=" + hGroupPersonNum
				+ ", 취미 게시글 소모임 지원자=" + hGroupApplyPerson + ", 취미 게시글 소모임 지원자수=" + hGroupApplyPersonNum + ", 취미 게시글 생성일="
				+ hBoardCreateDate + ", 취미 게시글 수정일=" + hBoardUpdateDate
				+ ", 취미 게시글 상태=" + hBoardStatus + ", 취미 게시글 파일이름=" + hBoardFilename + ", 취미 게시글 파일리네임="
				+ hBoardFilerename + ", 취미 게시글 파일경로=" + hBoardFilepath + ", 취미 게시글 파일길이=" + hBoardFilelength
				+ "]";
	}
	
}
