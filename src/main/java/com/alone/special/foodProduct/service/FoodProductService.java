package com.alone.special.foodProduct.service;

import java.util.List;

import com.alone.special.foodProduct.domain.FoodProduct;
import com.alone.special.foodProduct.domain.FoodProductFile;
import com.alone.special.foodProduct.domain.FoodProductOneRev;
import com.alone.special.foodProduct.domain.FoodProductPhotoRev;
import com.alone.special.foodProduct.domain.FoodProductPhotoRevFile;
import com.alone.special.foodProduct.domain.PageInfo;

public interface FoodProductService {

	/**
	 * 추천상품 등록 서비스
	 * @param fProduct
	 * @return 
	 */
	int insertProductInfo(FoodProduct fProduct);
	/**
	 * 추천상품 파일 등록 서비스
	 * @param fList
	 * @return
	 */
	int insertProductFiles(List<FoodProductFile> fList);
	/**
	 * 상품 등록 시퀀스 확인 서비스
	 * @return
	 */
    int getCurrentProductId();
    /**
     * 리스트 전체 갯수 확인 서비스
     * @return
     */
	Integer getListCount();
	/**
	 * 전체 추천상품 리스트로 가져오기 서비스
	 * @param pInfo
	 * @return
	 */
	List<FoodProduct> selectProductInfoList(PageInfo pInfo);
	/**
	 * 전체 추천상품파일 리스트로 가져오기 서비스
	 * @return
	 */
	List<FoodProductFile> selectProductFileList();
	/**
	 * 카테고리별 리스트 카운트 서비스
	 * @param category
	 * @return
	 */
	Integer getListCountByCategory(String category);
	/**
	 * 카테고리별 상품정보 리스트로 가져오기 서비스
	 * @param category
	 * @param pInfo
	 * @return
	 */
	List<FoodProduct> selectProductInfoListByCategory(String category, PageInfo pInfo);
	/**
	 * 상품ID로 상품정보 객체로 가져오기 서비스
	 * @param fProductId
	 * @return
	 */
	FoodProduct selectDetailInfoByFProductId(int fProductId);
	/**
	 * 연관상품ID로 상품파일 리스트로 가져오기 서비스
	 * @param refFProductId
	 * @return
	 */
	List<FoodProductFile> selectDetailFileByRefFProductId(Integer refFProductId);
	/**
	 * 포토리뷰 정보 등록 서비스
	 * @param fProductPhotoRev
	 * @return
	 */
	int insertPhotoRevInfo(FoodProductPhotoRev fProductPhotoRev);
	/**
	 * 리뷰등록시 필요한 시퀀스 조회 서비스
	 * @return
	 */
	int getCurrentFProductRevId();
	/**
	 * 포토리뷰 파일 등록 서비스
	 * @param fPhotoRevList
	 * @return
	 */
	int insertPhotoRevFiles(List<FoodProductPhotoRevFile> fPhotoRevList);
	/**
	 * 리뷰 갯수 카운트 서비스
	 * @return
	 */
	Integer getRevListCount();
	/**
	 * 포토리뷰 상품아이디별 리스트로 가져오기 서비스
	 * @param fProductId
	 * @param pInfo
	 * @return
	 */
	List<FoodProductPhotoRev> selectPhotoRevList(int fProductId,PageInfo pInfo);
	/**
	 * 포토리뷰 파일 전체 가져오기 서비스
	 * @return
	 */
	List<FoodProductPhotoRevFile> selectPhotoRevFileList();
	/**
	 * 한줄리뷰 등록 서비스
	 * @param fPOneRev
	 * @return
	 */
	int oneReviewRegister(FoodProductOneRev fPOneRev);
	/**
	 * 상품ID별 한줄리뷰 리스트로 가져오기 서비스
	 * @param fProductId
	 * @return
	 */
	List<FoodProductOneRev> selectOneRevList(int fProductId);
	/**
	 * 추천상품 삭제 서비스
	 * @param fProductId
	 * @return
	 */
	int deleteProduct(int fProductId);
	/**
	 * 포토리뷰 삭제 서비스
	 * @param fPPhotoRev
	 * @return
	 */
	int photoRevDelete(FoodProductPhotoRev fPPhotoRev);
	/**
	 * 한줄리뷰 삭제 서비스
	 * @param fPOneRev
	 * @return
	 */
	int oneRevDelete(FoodProductOneRev fPOneRev);
	/**
	 * 상품ID로 별점 가져오기 서비스
	 * @param fProductId
	 * @return
	 */
	float getStarByfProductId(Integer fProductId);



	


	

}
