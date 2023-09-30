package com.alone.special.product.service;

import java.util.List;
import java.util.Map;

import com.alone.special.product.domain.Product;
import com.alone.special.product.domain.ProductPageInfo;

public interface ProductService {

	int insertProduct(Product product);

	int getListCount();

	List<Product> selectProductLust(ProductPageInfo pInfo);

	Product selectProductById(Integer sProductId);


	int updateProduct(Product product);

	int deleteProduct(Integer sProductId);

	int getProductListCount(Map<String, String> paramMap);

	List<Product> searchNoticesByKeyword(ProductPageInfo pInfo, Map<String, String> paramMap);




}
