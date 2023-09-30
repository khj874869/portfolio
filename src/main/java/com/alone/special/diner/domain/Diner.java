package com.alone.special.diner.domain;

import java.sql.Date;

public class Diner {
	private int fDinerId; //시퀀스
	private String fDinerName; //입력
	private String fDinerAddress; //입력
	private String fDinerParking; //입력
	private String fDinerPhone; //입력
	private String fDinerBHour; //입력
	private String fDinerType; //입력
	private String fDinerNote; //입력
	private Date fDinerDate; //디폴트
	public int getfDinerId() {
		return fDinerId;
	}
	public void setfDinerId(int fDinerId) {
		this.fDinerId = fDinerId;
	}
	public String getfDinerName() {
		return fDinerName;
	}
	public void setfDinerName(String fDinerName) {
		this.fDinerName = fDinerName;
	}
	public String getfDinerAddress() {
		return fDinerAddress;
	}
	public void setfDinerAddress(String fDinerAddress) {
		this.fDinerAddress = fDinerAddress;
	}
	public String getfDinerParking() {
		return fDinerParking;
	}
	public void setfDinerParking(String fDinerParking) {
		this.fDinerParking = fDinerParking;
	}
	public String getfDinerPhone() {
		return fDinerPhone;
	}
	public void setfDinerPhone(String fDinerPhone) {
		this.fDinerPhone = fDinerPhone;
	}
	public String getfDinerBHour() {
		return fDinerBHour;
	}
	public void setfDinerBHour(String fDinerBHour) {
		this.fDinerBHour = fDinerBHour;
	}
	public String getfDinerType() {
		return fDinerType;
	}
	public void setfDinerType(String fDinerType) {
		this.fDinerType = fDinerType;
	}
	public String getfDinerNote() {
		return fDinerNote;
	}
	public void setfDinerNote(String fDinerNote) {
		this.fDinerNote = fDinerNote;
	}
	public Date getfDinerDate() {
		return fDinerDate;
	}
	public void setfDinerDate(Date fDinerDate) {
		this.fDinerDate = fDinerDate;
	}
	@Override
	public String toString() {
		return "추천식당 [fDinerId=" + fDinerId + ", fDinerName=" + fDinerName + ", fDinerAddress=" + fDinerAddress
				+ ", fDinerParking=" + fDinerParking + ", fDinerPhone=" + fDinerPhone + ", fDinerBHour=" + fDinerBHour
				+ ", fDinerType=" + fDinerType + ", fDinerNote=" + fDinerNote + ", fDinerDate=" + fDinerDate + "]";
	}


	
	
}
