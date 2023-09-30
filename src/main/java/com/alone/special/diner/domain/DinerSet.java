package com.alone.special.diner.domain;

public class DinerSet {
	private Diner diner;
	private DinerFile dinerFile;
	public Diner getDiner() {
		return diner;
	}
	public void setDiner(Diner diner) {
		this.diner = diner;
	}
	public DinerFile getDinerFile() {
		return dinerFile;
	}
	public void setDinerFile(DinerFile dinerFile) {
		this.dinerFile = dinerFile;
	}
	@Override
	public String toString() {
		return "추천식당세트 [식당정보=" + diner + ", 식당파일=" + dinerFile + "]";
	}
	
	
}
