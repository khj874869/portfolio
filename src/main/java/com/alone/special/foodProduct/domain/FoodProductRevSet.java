package com.alone.special.foodProduct.domain;

import java.util.List;

public class FoodProductRevSet {
	private FoodProductPhotoRev FPPhotoRev ;
	private List<FoodProductPhotoRevFile> FPPhotoRevFile;
	public FoodProductPhotoRev getFPPhotoRev() {
		return FPPhotoRev;
	}
	public void setFPPhotoRev(FoodProductPhotoRev fPPhotoRev) {
		FPPhotoRev = fPPhotoRev;
	}
	public List<FoodProductPhotoRevFile> getFPPhotoRevFile() {
		return FPPhotoRevFile;
	}
	public void setFPPhotoRevFile(List<FoodProductPhotoRevFile> fPPhotoRevFile) {
		FPPhotoRevFile = fPPhotoRevFile;
	}
	@Override
	public String toString() {
		return "포토리뷰세트 [포토리뷰정보=" + FPPhotoRev + ", 포토리뷰이미지=" + FPPhotoRevFile + "]";
	}
	
}
