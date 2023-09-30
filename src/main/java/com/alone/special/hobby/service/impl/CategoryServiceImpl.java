package com.alone.special.hobby.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.special.hobby.domain.Category;
import com.alone.special.hobby.service.CategoryService;
import com.alone.special.hobby.store.CategoryStore;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private SqlSession session;
	@Autowired
	private CategoryStore cStore;
	
	@Override
	public int insertCategory(Category category) {
		int result = cStore.insertCategory(session, category);
		return result;
	}

	@Override
	public List<Category> selectAllCategoryList() {
		List<Category> cList = cStore.selectAllCategoryList(session);
		return cList;
	}

	@Override
	public List<Category> selectByTag(String searchCondition) {
		List<Category> tagList = cStore.selectByTag(session, searchCondition);
		return tagList;
	}

	@Override
	public List<Category> searchByKeyword(String searchKeyword) {
		List<Category> keyList = cStore.searchByKeyword(session, searchKeyword);
		return keyList;
	}

	@Override
	public int deleteCategory(Category category) {
		int result = cStore.deleteCategory(session, category);
		return result;
	}

}
