package com.alone.special.product.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.special.product.domain.Product;
import com.alone.special.product.domain.ProductPageInfo;
import com.alone.special.product.service.ProductService;
import com.alone.special.product.store.ProductStore;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
private ProductStore store;
@Autowired
private SqlSession session;
@Override
public int insertProduct(Product product) {
	int result = store.insertProduct(session,product);
	return result;
}
@Override
public int getListCount() {
	int result = store.selectListCount(session);
	return result;
}
@Override
public List<Product> selectProductLust(ProductPageInfo pInfo) {
	List<Product> pList = store.selectProductList(session,pInfo);
	return pList;
}
@Override
public Product selectProductById(Integer sProductId) {
	Product productOne = store.selectOne(session,sProductId);
	return productOne;
}
@Override
public int updateProduct(Product product) {
	int result = store.updateproduct(session,product);
	return result;
	
}
@Override
public int deleteProduct(Integer sProductId) {
	int result = store.deleteproduct(session,sProductId);
	return result;
}
@Override
public int getProductListCount(Map<String, String> paramMap) {
	int result = store.selectProductListCount(session, paramMap);
	return result;
}
@Override
public List<Product> searchNoticesByKeyword(ProductPageInfo pInfo, Map<String, String> paramMap) {
	List<Product> searchList  = store.selectNoticesByKeyword(session, pInfo, paramMap);
	return searchList;
}

}
