package com.alone.special.noticeEvent.domain;

import java.sql.Date;

public class NoticeEvent {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String boardFileName;
	private String boardFileRename;
	private String boardFilePath;
	private long boardFileLength;
	private Date bCreateDate;
	private Date bUpdateDate;
	private String boardType;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardFileName() {
		return boardFileName;
	}
	public void setBoardFileName(String boardFileName) {
		this.boardFileName = boardFileName;
	}
	public String getBoardFileRename() {
		return boardFileRename;
	}
	public void setBoardFileRename(String boardFileRename) {
		this.boardFileRename = boardFileRename;
	}
	public String getBoardFilePath() {
		return boardFilePath;
	}
	public void setBoardFilePath(String boardFilePath) {
		this.boardFilePath = boardFilePath;
	}
	public long getBoardFileLength() {
		return boardFileLength;
	}
	public void setBoardFileLength(long boardFileLength) {
		this.boardFileLength = boardFileLength;
	}
	public Date getbCreateDate() {
		return bCreateDate;
	}
	public void setbCreateDate(Date bCreateDate) {
		this.bCreateDate = bCreateDate;
	}
	public Date getbUpdateDate() {
		return bUpdateDate;
	}
	public void setbUpdateDate(Date bUpdateDate) {
		this.bUpdateDate = bUpdateDate;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	@Override
	public String toString() {
		return "공지이벤트 [번호=" + boardNo + ", 제목=" + boardTitle + ", 내용=" + boardContent
				+ ", 작성자=" + boardWriter + ", 파일이름=" + boardFileName + ", 파일리네임="
				+ boardFileRename + ", 파일경로=" + boardFilePath + ", 파일크기=" + boardFileLength
				+ ", 작성일=" + bCreateDate + ", 수정일=" + bUpdateDate + ", 게시글타입=" + boardType + "]";
	}
	
	
}
