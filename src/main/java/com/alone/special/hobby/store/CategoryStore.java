package com.alone.special.hobby.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alone.special.hobby.domain.Category;

public interface CategoryStore {

	public int insertCategory(SqlSession session, Category category);

	public List<Category> selectAllCategoryList(SqlSession session);

	public List<Category> selectByTag(SqlSession session, String searchCondition);

	public List<Category> searchByKeyword(SqlSession session, String searchKeyword);

	public int deleteCategory(SqlSession session, Category category);

}
