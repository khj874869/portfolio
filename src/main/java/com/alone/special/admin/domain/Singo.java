package com.alone.special.admin.domain;

public class Singo {
	private String singoNo;
	private String singoReason;
	private String singoContent;
	private String singoLocation;
	private String singoLocationTitle;
	private String singoId;
	
	public String getSingoNo() {
		return singoNo;
	}
	public void setSingoNo(String singoNo) {
		this.singoNo = singoNo;
	}
	public String getSingoReason() {
		return singoReason;
	}
	public void setSingoReason(String singoReason) {
		this.singoReason = singoReason;
	}
	public String getSingoContent() {
		return singoContent;
	}
	public void setSingoContent(String singoContent) {
		this.singoContent = singoContent;
	}
	public String getSingoLocation() {
		return singoLocation;
	}
	public void setSingoLocation(String singoLocation) {
		this.singoLocation = singoLocation;
	}
	public String getSingoLocationTitle() {
		return singoLocationTitle;
	}
	public void setSingoLocationTitle(String singoLocationTitle) {
		this.singoLocationTitle = singoLocationTitle;
	}
	public String getSingoId() {
		return singoId;
	}
	public void setSingoId(String singoId) {
		this.singoId = singoId;
	}
	@Override
	public String toString() {
		return "신고 [번호=" + singoNo + ", 신고이유=" + singoReason + ", 신고내용=" + singoContent
				+ ", 신고위치=" + singoLocation + ", 신고위치제목=" + singoLocationTitle + ", 신고된 아이디="
				+ singoId + "]";
	}
	
}
