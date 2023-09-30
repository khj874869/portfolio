package com.alone.special.hobby.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.alone.special.hobby.domain.Board;
import com.alone.special.hobby.domain.Category;
import com.alone.special.hobby.domain.PageInfo;

public interface BoardStore {

	int insertBoard(SqlSession session, Board board);

	Board selectBoardByNo(SqlSession session, Integer hBoardNo);

	int updateBoard(SqlSession session, Board board);

	int deleteBoard(SqlSession session, Board board);

	List<Board> selectBoardList(SqlSession session, Map<String, Object> getListMap);

	int getListCount(SqlSession session, String refCategoryName);

	int getListCountByKeyword(SqlSession session, Map<String, String> paramMap);

	List<Board> searchBoardsByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap);

	int updateApplyInfo(SqlSession session, Board board);

	int createAutoBoard(SqlSession session, Board boardOne);

	List<Board> searchBoardsByCondition(SqlSession session, PageInfo pInfo, Map<String, String> paramMap);

	int getListCountByCondition(SqlSession session, Map<String, String> paramMap);

	int updateReplyNum(SqlSession session, Map<String, Integer> replyCountInfo);

	int deleteBoardByCategoryDelete(SqlSession session, Category category);

	List<Board> selectBoardListByCategoryForAdmin(SqlSession session, PageInfo pInfo, String refCategoryName);

	List<Board> selectAllBoardListForAdmin(SqlSession session, PageInfo pInfo);

	int getListCountForAdmin(SqlSession session);

	int getListCountBySession(SqlSession session, Map<String, String> paramMap);

	List<Board> searchBoardsBySession(SqlSession session, PageInfo pInfo, Map<String, String> paramMap);

	List<Board> selectBoardListByCategory(SqlSession session, Category category);

}
