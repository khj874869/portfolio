package com.alone.special.securitycomment.domain;

import java.sql.Timestamp;

public class Comment {
private Integer sCommentNo;
private Integer userNo;
private int sRecommend;
private String userId;
private String sCommentContent;
private Timestamp sCreateComment;
private Timestamp sUpdateComment;


public void setsRecommend(int sRecommend) {
	this.sRecommend = sRecommend;
}
public int getsRecommend() {
	return sRecommend;
}
public Integer getsCommentNo() {
	return sCommentNo;
}
public void setsCommentNo(Integer sCommentNo) {
	this.sCommentNo = sCommentNo;
}
public Integer getUserNo() {
	return userNo;
}
public void setUserNo(Integer userNo) {
	this.userNo = userNo;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getsCommentContent() {
	return sCommentContent;
}
public void setsCommentContent(String sCommentContent) {
	this.sCommentContent = sCommentContent;
}
public Timestamp getsCreateComment() {
	return sCreateComment;
}
public void setsCreateComment(Timestamp sCreateComment) {
	this.sCreateComment = sCreateComment;
}
public Timestamp getsUpdateComment() {
	return sUpdateComment;
}
public void setsUpdateComment(Timestamp sUpdateComment) {
	this.sUpdateComment = sUpdateComment;
}
@Override
public String toString() {
	return "Comment [sCommentNo=" + sCommentNo + ", userNo=" + userNo + ", userId=" + userId + ", sCommentContent="
			+ sCommentContent + ", sCreateComment=" + sCreateComment + ", sUpdateComment=" + sUpdateComment + "]";
}

}
