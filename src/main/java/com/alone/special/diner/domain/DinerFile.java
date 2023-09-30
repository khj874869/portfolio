package com.alone.special.diner.domain;

public class DinerFile {
	private int refFDinerId; // 받기
	private int fDinerFileorder; // 1,2,3,4 매기기
	private String fDinerFilename; // 가져옴
	private String fDinerFilerename; // // 가져옴
	private String fDinerFilepath; // // 가져옴
	private int fDinerFiletype; // 설정해
	public int getRefFDinerId() {
		return refFDinerId;
	}
	public void setRefFDinerId(int refFDinerId) {
		this.refFDinerId = refFDinerId;
	}
	public int getfDinerFileorder() {
		return fDinerFileorder;
	}
	public void setfDinerFileorder(int fDinerFileorder) {
		this.fDinerFileorder = fDinerFileorder;
	}
	public String getfDinerFilename() {
		return fDinerFilename;
	}
	public void setfDinerFilename(String fDinerFilename) {
		this.fDinerFilename = fDinerFilename;
	}
	public String getfDinerFilerename() {
		return fDinerFilerename;
	}
	public void setfDinerFilerename(String fDinerFilerename) {
		this.fDinerFilerename = fDinerFilerename;
	}
	public String getfDinerFilepath() {
		return fDinerFilepath;
	}
	public void setfDinerFilepath(String fDinerFilepath) {
		this.fDinerFilepath = fDinerFilepath;
	}
	public int getfDinerFiletype() {
		return fDinerFiletype;
	}
	public void setfDinerFiletype(int fDinerFiletype) {
		this.fDinerFiletype = fDinerFiletype;
	}
	@Override
	public String toString() {
		return "DinerFile [refFDinerId=" + refFDinerId + ", fDinerFileorder=" + fDinerFileorder + ", fDinerFilename="
				+ fDinerFilename + ", fDinerFilerename=" + fDinerFilerename + ", fDinerFilepath=" + fDinerFilepath
				+ ", fDinerFiletype=" + fDinerFiletype + "]";
	}
	
	

	
}
