package com.alone.special.foodProduct.domain;


public class FoodProductSet {
	
	private FoodProduct foodProduct;
	private FoodProductFile foodProductFile;
	
	public FoodProduct getFoodProduct() {
		return foodProduct;
	}

	public void setFoodProduct(FoodProduct foodProduct) {
		this.foodProduct = foodProduct;
	}

	public FoodProductFile getFoodProductFile() {
		return foodProductFile;
	}

	public void setFoodProductFile(FoodProductFile foodProductFile) {
		this.foodProductFile = foodProductFile;
	}

	@Override
	public String toString() {
		return "추천상품세트 [상품정보=" + foodProduct + ", 상품이미지=" + foodProductFile + "]";
	}
	
	
}
