package com.alone.special.hobby.service;

import java.util.List;
import java.util.Map;

import com.alone.special.hobby.domain.Board;
import com.alone.special.hobby.domain.Category;
import com.alone.special.hobby.domain.PageInfo;

public interface BoardService {

	int insertBoard(Board board);

	Board selectBoardByNo(Integer hBoardNo);

	int updateBoard(Board board);

	int deleteBoard(Board board);

	List<Board> selectBoardList(Map<String, Object> getListMap);

	Integer getListCount(String refCategoryName);

	int getListCountByKeyword(Map<String, String> paramMap);

	List<Board> searchBoardsByKeyword(PageInfo pInfo, Map<String, String> paramMap);

	int updateApplyInfo(Board board);

	int createAutoBoard(Board boardOne);

	List<Board> searchBoardsByCondition(PageInfo pInfo, Map<String, String> paramMap);

	int getListCountByCondition(Map<String, String> paramMap);

	int updateReplyNum(Map<String, Integer> replyCountInfo);

	int deleteBoardByCategoryDelete(Category category);
	
	List<Board> selectBoardListByCategoryForAdmin(String refCategoryName, PageInfo pInfo);
	
	List<Board> selectAllBoardListForAdmin(PageInfo pInfo);
	
	int getListCountForAdmin();

	int getListCountBySession(Map<String, String> paramMap);

	List<Board> searchBoardsBySession(PageInfo pInfo, Map<String, String> paramMap);

	List<Board> selectBoardListByCategory(Category category);

}
