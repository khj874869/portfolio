package com.alone.special.review.domain;



import java.sql.Timestamp;

import oracle.sql.TIMESTAMP;

public class Review {
	private int sReviewId;
	private Integer sProductId;
	private Integer sUserNo;
	private String sUserId;
	private String sReviewContent;
	private int sReviewReCommend;
	private String sFileName;
	private int sRating;
	private String sFileReName;
	private String sFilePath;
	private long sFileLength;
	private Timestamp sCreateDate;
	private  Timestamp sUpdateDate;
	
	public int getsReviewReCommend() {
		return sReviewReCommend;
	}
	public void setsReviewReCommend(int sReviewReCommend) {
		this.sReviewReCommend = sReviewReCommend;
	}
	public String getsFileName() {
		return sFileName;
	}
	public void setsFileName(String sFileName) {
		this.sFileName = sFileName;
	}
	public String getsUserId() {
		return sUserId;
	}
	public void setsUserId(String sUserId) {
		this.sUserId = sUserId;
	}
	public int getsReviewId() {
		return this.sReviewId;
	}
	public void setsReviewId(Integer sReviewId) {
		this.sReviewId = sReviewId;
	}
	public Integer getsProductId() {
		return sProductId;
	}
	public void setsProductId(int sProductId) {
		this.sProductId = sProductId;
	}
	public Integer getsUserNo() {
		return sUserNo;
	}
	public void setsUserNo(Integer sUserNo) {
		this.sUserNo = sUserNo;
	}
	public String getsReviewContent() {
		return sReviewContent;
	}
	public void setsReviewContent(String sReviewContent) {
		this.sReviewContent = sReviewContent;
	}
	public int getsRating() {
		return sRating;
	}
	public void setsRating(int sRating) {
		this.sRating = sRating;
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
	public long getsFileLength() {
		return sFileLength;
	}
	public void setsFileLength(long sFileLength) {
		this.sFileLength = sFileLength;
	}
	public Timestamp getsCreateDate() {
		return sCreateDate;
	}
	public void setsCreateDate(Timestamp sCreateDate) {
		this.sCreateDate = sCreateDate;
	}
	public Timestamp getsUpdateDate() {
		return sUpdateDate;
	}
	public void setsUpdateDate(Timestamp sUpdateDate) {
		this.sUpdateDate = sUpdateDate;
	}
	@Override
	public String toString() {
		return "Review [리뷰번호=" + sReviewId + ", 상품아이디=" + sProductId + ", 유저번호=" + sUserNo + ", 유저아이디="
				+ sUserId + ", 리뷰내용=" + sReviewContent + ", 리뷰추천=" + sReviewReCommend
				+ ", 리뷰비추천=" + sFileName + ", 별점=" + sRating + ", 첨부파일이름=" + sFileReName
				+ ", 첨부파일경로=" + sFilePath + ", 첨부파일길이=" + sFileLength + ", 생성일자=" + sCreateDate
				+ ", 수정일자=" + sUpdateDate + "]";
	}
	
	
}
