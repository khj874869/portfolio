package com.alone.special.hobby.service;

import java.util.List;

import com.alone.special.hobby.domain.Category;

public interface CategoryService {

	public int insertCategory(Category category);

	public List<Category> selectAllCategoryList();

	public List<Category> selectByTag(String searchCondition);

	public List<Category> searchByKeyword(String searchKeyword);

	public int deleteCategory(Category category);

}
