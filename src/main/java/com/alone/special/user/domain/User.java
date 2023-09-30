package com.alone.special.user.domain;

import java.sql.Date;

public class User {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userGender;
	private String userEmail;
	private String userPhone;
	private String userAddr;
	private String userHobby;
	private Date createDate;
	private char userGrade;
	
	public User() {
		super();
	}
	
	public User(String userId, String userEmail) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
	}

	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserHobby() {
		return userHobby;
	}
	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public char getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(char userGrade) {
		this.userGrade = userGrade;
	}
	
	@Override
	public String toString() {
		return "회원 [회원번호=" + userNo + ", 회원아이디=" + userId + ", 회원비밀번호=" + userPw + ", 회원이름=" + userName
				+ ", 회원성별=" + userGender + ", 회원이메일=" + userEmail + ", 회원전화번호=" + userPhone + ", 회원주소="
				+ userAddr + ", 회원취미=" + userHobby + ", 회원가입일=" + createDate + ", 회원등급=" + userGrade
				+ "]";
	}
}
