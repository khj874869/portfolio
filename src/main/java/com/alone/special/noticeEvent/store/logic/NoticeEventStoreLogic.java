package com.alone.special.noticeEvent.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.alone.special.noticeEvent.domain.NoticeEvent;
import com.alone.special.noticeEvent.domain.PageInfo;
import com.alone.special.noticeEvent.store.NoticeEventStore;

@Repository
public class NoticeEventStoreLogic implements NoticeEventStore{

	@Override
	public int selectNoticeListCount(SqlSession sqlSession) {
		int result = sqlSession.selectOne("NoticeEventMapper.selectNoticeListCount");
		return result;
	}

	@Override
	public List<NoticeEvent> selectNoticeList(SqlSession sqlSession, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<NoticeEvent> nList = sqlSession.selectList("NoticeEventMapper.selectNoticeList", null, rowBounds);
		return nList;
	}
	
	@Override
	public int selectEventListCount(SqlSession sqlSession) {
		int result = sqlSession.selectOne("NoticeEventMapper.selectEventListCount");
		return result;
	}
	
	@Override
	public List<NoticeEvent> selectEventList(SqlSession sqlSession, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<NoticeEvent> eList = sqlSession.selectList("NoticeEventMapper.selectEventList", null, rowBounds);
		return eList;
	}

	@Override
	public int getNoticeListCount(SqlSession sqlSession, String searchKeyword) {
		int result = sqlSession.selectOne("NoticeEventMapper.getNoticeListCount", searchKeyword);
		return result;
	}

	@Override
	public List<NoticeEvent> searchNoticeByKeyword(SqlSession sqlSession, PageInfo pInfo, String searchKeyword) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<NoticeEvent> sList = sqlSession.selectList("NoticeEventMapper.searchNoticeByKeyword", searchKeyword, rowBounds);
		return sList;
	}

	@Override
	public int getEventListCount(SqlSession sqlSession, String searchKeyword) {
		int result = sqlSession.selectOne("NoticeEventMapper.getEventListCount", searchKeyword);
		return result;
	}

	@Override
	public List<NoticeEvent> searchEventByKeyword(SqlSession sqlSession, PageInfo pInfo, String searchKeyword) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<NoticeEvent> sList = sqlSession.selectList("NoticeEventMapper.searchEventByKeyword", searchKeyword, rowBounds);
		return sList;
	}

	@Override
	public NoticeEvent selectNoticeByNo(SqlSession sqlSession, Integer boardNo) {
		NoticeEvent noticeOne = sqlSession.selectOne("NoticeEventMapper.selectNoticeByNo", boardNo);
		return noticeOne;
	}

	@Override
	public int deleteNotice(SqlSession sqlSession, Integer boardNo) {
		int result = sqlSession.delete("NoticeEventMapper.deleteNotice", boardNo);
		return result;
	}

	@Override
	public int insertNoticeEvent(SqlSession sqlSession, NoticeEvent noticeEvent) {
		int	result = sqlSession.insert("NoticeEventMapper.insertNoticeEvent", noticeEvent);
		return result;
	}

	@Override
	public int modifyNoticeEvent(SqlSession sqlSession, NoticeEvent noticeEvent) {
		int result = sqlSession.update("NoticeEventMapper.modifyNoticeEvent", noticeEvent);
		return result;
	}

}
