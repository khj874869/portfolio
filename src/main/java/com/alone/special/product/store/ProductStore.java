package com.alone.special.product.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.alone.special.product.domain.Product;
import com.alone.special.product.domain.ProductPageInfo;

public interface ProductStore {

	int insertProduct(SqlSession session, Product product);

	int selectListCount(SqlSession session);

	List<Product> selectProductList(SqlSession session, ProductPageInfo pInfo);

	Product selectOne(SqlSession session, Integer sProductId);


	int updateproduct(SqlSession session, Product product);

	int deleteproduct(SqlSession session, Integer sProductId);

	int selectProductListCount(SqlSession session, Map<String, String> paramMap);

	List<Product> selectNoticesByKeyword(SqlSession session, ProductPageInfo pInfo, Map<String, String> paramMap);
	
}
