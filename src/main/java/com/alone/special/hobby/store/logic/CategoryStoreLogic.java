package com.alone.special.hobby.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.alone.special.hobby.domain.Category;
import com.alone.special.hobby.store.CategoryStore;

@Repository
public class CategoryStoreLogic implements CategoryStore {

	@Override
	public int insertCategory(SqlSession session, Category category) {
		int result = session.insert("CategoryMapper.insertCategory", category);
		return result;
	}

	@Override
	public List<Category> selectAllCategoryList(SqlSession session) {
		List<Category> cList = session.selectList("CategoryMapper.selectAllCategoryList");
		return cList;
	}

	@Override
	public List<Category> selectByTag(SqlSession session, String searchCondition) {
		List<Category> tagList = session.selectList("CategoryMapper.selectByTag", searchCondition);
		return tagList;
	}

	@Override
	public List<Category> searchByKeyword(SqlSession session, String searchKeyword) {
		List<Category> keyList = session.selectList("CategoryMapper.searchByKeyword", searchKeyword);
		return keyList;
	}

	@Override
	public int deleteCategory(SqlSession session, Category category) {
		int result = session.delete("CategoryMapper.deleteCategory", category);
		return result;
	}

}
