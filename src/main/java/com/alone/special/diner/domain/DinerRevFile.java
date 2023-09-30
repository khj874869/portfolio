package com.alone.special.diner.domain;

public class DinerRevFile {
	private int refFDinerId;
	private int fDinerRevFileorder;
	private String fDinerRevFilename;
	private String fDinerRevFilerename;
	private String fDinerRevFilepath;
	public int getRefFDinerId() {
		return refFDinerId;
	}
	public void setRefFDinerId(int refFDinerId) {
		this.refFDinerId = refFDinerId;
	}
	public int getfDinerRevFileorder() {
		return fDinerRevFileorder;
	}
	public void setfDinerRevFileorder(int fDinerRevFileorder) {
		this.fDinerRevFileorder = fDinerRevFileorder;
	}
	public String getfDinerRevFilename() {
		return fDinerRevFilename;
	}
	public void setfDinerRevFilename(String fDinerRevFilename) {
		this.fDinerRevFilename = fDinerRevFilename;
	}
	public String getfDinerRevFilerename() {
		return fDinerRevFilerename;
	}
	public void setfDinerRevFilerename(String fDinerRevFilerename) {
		this.fDinerRevFilerename = fDinerRevFilerename;
	}
	public String getfDinerRevFilepath() {
		return fDinerRevFilepath;
	}
	public void setfDinerRevFilepath(String fDinerRevFilepath) {
		this.fDinerRevFilepath = fDinerRevFilepath;
	}
	@Override
	public String toString() {
		return "DinerRevFile [refFDinerId=" + refFDinerId + ", fDinerRevFileorder=" + fDinerRevFileorder
				+ ", fDinerRevFilename=" + fDinerRevFilename + ", fDinerRevFilerename=" + fDinerRevFilerename
				+ ", fDinerRevFilepath=" + fDinerRevFilepath + "]";
	}
	
	
	
}
