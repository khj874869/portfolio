package com.alone.special.hobby.domain;

import java.sql.Timestamp;

public class Reply {

	private int hReplyNo;
	private int refBoardNo;
	private String hReplyContent;
	private String hReplyWriter;
	private Timestamp hReplyCreateDate;
	private Timestamp hReplyUpdateDate;
	private char hReplyUpdateStatus;
	private char hReplyStatus;
	
	public int gethReplyNo() {
		return hReplyNo;
	}
	public void sethReplyNo(int hReplyNo) {
		this.hReplyNo = hReplyNo;
	}
	public int getRefBoardNo() {
		return refBoardNo;
	}
	public void setRefBoardNo(int refBoardNo) {
		this.refBoardNo = refBoardNo;
	}
	public String gethReplyContent() {
		return hReplyContent;
	}
	public void sethReplyContent(String hReplyContent) {
		this.hReplyContent = hReplyContent;
	}
	public String gethReplyWriter() {
		return hReplyWriter;
	}
	public void sethReplyWriter(String hReplyWriter) {
		this.hReplyWriter = hReplyWriter;
	}
	public Timestamp gethReplyCreateDate() {
		return hReplyCreateDate;
	}
	public void sethReplyCreateDate(Timestamp hReplyCreateDate) {
		this.hReplyCreateDate = hReplyCreateDate;
	}
	public Timestamp gethReplyUpdateDate() {
		return hReplyUpdateDate;
	}
	public void sethReplyUpdateDate(Timestamp hReplyUpdateDate) {
		this.hReplyUpdateDate = hReplyUpdateDate;
	}
	public char gethReplyUpdateStatus() {
		return hReplyUpdateStatus;
	}
	public void sethReplyUpdateStatus(char hReplyUpdateStatus) {
		this.hReplyUpdateStatus = hReplyUpdateStatus;
	}
	public char gethReplyStatus() {
		return hReplyStatus;
	}
	public void sethReplyStatus(char hReplyStatus) {
		this.hReplyStatus = hReplyStatus;
	}
	
	@Override
	public String toString() {
		return "취미 댓글 [취미 댓글 번호=" + hReplyNo + ", 참고 게시글 번호=" + refBoardNo + ", 취미 댓글 내용=" + hReplyContent
				+ ", 취미 댓글 작성자=" + hReplyWriter + ", 취미 댓글 생성일=" + hReplyCreateDate + ", 취미 댓글 수정일="
				+ hReplyUpdateDate + ", 취미 댓글 수정상태=" + hReplyUpdateStatus + ", 취미 댓글 상태=" + hReplyStatus
				+ "]";
	}
	
}
