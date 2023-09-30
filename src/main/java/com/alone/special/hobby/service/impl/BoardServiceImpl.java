package com.alone.special.hobby.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.special.hobby.domain.Board;
import com.alone.special.hobby.domain.Category;
import com.alone.special.hobby.domain.PageInfo;
import com.alone.special.hobby.service.BoardService;
import com.alone.special.hobby.store.BoardStore;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private SqlSession session;
	@Autowired
	private BoardStore bStore;

	@Override
	public int insertBoard(Board board) {
		int result = bStore.insertBoard(session, board);
		return result;
	}

	@Override
	public Board selectBoardByNo(Integer hBoardNo) {
		Board boardOne = bStore.selectBoardByNo(session, hBoardNo);
		return boardOne;
	}

	@Override
	public int updateBoard(Board board) {
		int result = bStore.updateBoard(session, board);
		return result;
	}

	@Override
	public int deleteBoard(Board board) {
		int result = bStore.deleteBoard(session, board);
		return result;
	}

	@Override
	public List<Board> selectBoardList(Map<String, Object> getListMap) {
		List<Board> bList = bStore.selectBoardList(session, getListMap);
		return bList;
	}

	@Override
	public Integer getListCount(String refCategoryName) {
		int result = bStore.getListCount(session, refCategoryName);
		return result;
	}

	@Override
	public int getListCountByKeyword(Map<String, String> paramMap) {
		int result = bStore.getListCountByKeyword(session, paramMap);
		return result;
	}

	@Override
	public List<Board> searchBoardsByKeyword(PageInfo pInfo, Map<String, String> paramMap) {
		List<Board> searchList = bStore.searchBoardsByKeyword(session, pInfo, paramMap);
		return searchList;
	}

	@Override
	public int updateApplyInfo(Board board) {
		int result = bStore.updateApplyInfo(session, board);
		return result;
	}

	@Override
	public int createAutoBoard(Board boardOne) {
		int result = bStore.createAutoBoard(session, boardOne);
		return result;
	}

	@Override
	public List<Board> searchBoardsByCondition(PageInfo pInfo, Map<String, String> paramMap) {
		List<Board> searchList = bStore.searchBoardsByCondition(session, pInfo, paramMap);
		return searchList;
	}

	@Override
	public int getListCountByCondition(Map<String, String> paramMap) {
		int result = bStore.getListCountByCondition(session, paramMap);
		return result;
	}

	@Override
	public int updateReplyNum(Map<String, Integer> replyCountInfo) {
		int result = bStore.updateReplyNum(session, replyCountInfo);
		return result;
	}

	@Override
	public int deleteBoardByCategoryDelete(Category category) {
		int result = bStore.deleteBoardByCategoryDelete(session, category);
		return result;
	}

	@Override
	public List<Board> selectBoardListByCategoryForAdmin(String refCategoryName, PageInfo pInfo) {
		List<Board> searchList = bStore.selectBoardListByCategoryForAdmin(session, pInfo, refCategoryName);
		return searchList;
	}

	@Override
	public List<Board> selectAllBoardListForAdmin(PageInfo pInfo) {
		List<Board> bList = bStore.selectAllBoardListForAdmin(session, pInfo);
		return bList;
	}

	@Override
	public int getListCountForAdmin() {
		int result = bStore.getListCountForAdmin(session);
		return result;
	}

	@Override
	public int getListCountBySession(Map<String, String> paramMap) {
		int result = bStore.getListCountBySession(session, paramMap);
		return result;
	}

	@Override
	public List<Board> searchBoardsBySession(PageInfo pInfo, Map<String, String> paramMap) {
		List<Board> searchList = bStore.searchBoardsBySession(session, pInfo, paramMap);
		return searchList;
	}

	@Override
	public List<Board> selectBoardListByCategory(Category category) {
		List<Board> searchList = bStore.selectBoardListByCategory(session, category);
		return searchList;
	}

}
