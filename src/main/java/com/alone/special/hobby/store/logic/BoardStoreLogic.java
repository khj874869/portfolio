package com.alone.special.hobby.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.alone.special.hobby.domain.Board;
import com.alone.special.hobby.domain.Category;
import com.alone.special.hobby.domain.PageInfo;
import com.alone.special.hobby.store.BoardStore;

@Repository
public class BoardStoreLogic implements BoardStore {

	@Override
	public int insertBoard(SqlSession session, Board board) {
		int result = session.insert("BoardMapper.insertBoard", board);
		return result;
	}

	@Override
	public Board selectBoardByNo(SqlSession session, Integer hBoardNo) {
		Board boardOne = session.selectOne("BoardMapper.selectBoardByNo", hBoardNo);
		return boardOne;
	}

	@Override
	public int updateBoard(SqlSession session, Board board) {
		int result = session.update("BoardMapper.updateBoard", board);
		return result;
	}

	@Override
	public int deleteBoard(SqlSession session, Board board) {
		int result = session.update("BoardMapper.deleteBoard", board);
		return result;
	}

	@Override
	public List<Board> selectBoardList(SqlSession session, Map<String, Object> getListMap) {
		int limit = ((PageInfo)getListMap.get("pInfo")).getRecordCountPerPage();
	    int offset = (((PageInfo)getListMap.get("pInfo")).getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		String categoryName = (String) getListMap.get("refCategoryName");
		List<Board> bList = session.selectList("BoardMapper.selectBoardList", categoryName, rowBounds);
		return bList;
	}

	@Override
	public int getListCount(SqlSession session, String refCategoryName) {
		int result = session.selectOne("BoardMapper.getListCount", refCategoryName);
		return result;
	}

	@Override
	public int getListCountByKeyword(SqlSession session, Map<String, String> paramMap) {
		int result = session.selectOne("BoardMapper.getListCountByKeyword", paramMap);
		return result;
	}

	@Override
	public List<Board> searchBoardsByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> searchList = session.selectList("BoardMapper.searchBoardsByKeyword", paramMap, rowBounds);
		return searchList;
	}

	@Override
	public int updateApplyInfo(SqlSession session, Board board) {
		int result = session.update("BoardMapper.updateApplyInfo", board);
		return result;
	}

	@Override
	public int createAutoBoard(SqlSession session, Board boardOne) {
		int result = session.insert("BoardMapper.createAutoBoard", boardOne);
		return result;
	}

	@Override
	public List<Board> searchBoardsByCondition(SqlSession session, PageInfo pInfo, Map<String, String> paramMap) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> searchList = session.selectList("BoardMapper.searchBoardsByCondition", paramMap, rowBounds);
		return searchList;
	}

	@Override
	public int getListCountByCondition(SqlSession session, Map<String, String> paramMap) {
		int result = session.selectOne("BoardMapper.getListCountByCondition", paramMap);
		return result;
	}

	@Override
	public int updateReplyNum(SqlSession session, Map<String, Integer> replyCountInfo) {
		int result = session.update("BoardMapper.updateReplyNum", replyCountInfo);
		return result;
	}

	@Override
	public int deleteBoardByCategoryDelete(SqlSession session, Category category) {
		int result = session.delete("BoardMapper.deleteBoardByCategoryDelete", category);
		return result;
	}

	@Override
	public List<Board> selectBoardListByCategoryForAdmin(SqlSession session, PageInfo pInfo, String refCategoryName) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> searchList = session.selectList("BoardMapper.selectBoardListByCategoryForAdmin", refCategoryName, rowBounds);
		return searchList;
	}

	@Override
	public List<Board> selectAllBoardListForAdmin(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> bList = session.selectList("BoardMapper.selectAllBoardListForAdmin", null, rowBounds);
		return bList;
	}

	@Override
	public int getListCountForAdmin(SqlSession session) {
		int result = session.selectOne("BoardMapper.getListCountForAdmin");
		return result;
	}

	@Override
	public int getListCountBySession(SqlSession session, Map<String, String> paramMap) {
		int result = session.selectOne("BoardMapper.getListCountBySession", paramMap);
		return result;
	}

	@Override
	public List<Board> searchBoardsBySession(SqlSession session, PageInfo pInfo, Map<String, String> paramMap) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> searchList = session.selectList("BoardMapper.searchBoardsBySession", paramMap, rowBounds);
		return searchList;
	}

	@Override
	public List<Board> selectBoardListByCategory(SqlSession session, Category category) {
		List<Board> bList = session.selectList("BoardMapper.selectBoardListByCategoryForAdmin", category);
		return bList;
	}
	
}
