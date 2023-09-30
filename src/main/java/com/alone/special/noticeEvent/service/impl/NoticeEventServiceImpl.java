package com.alone.special.noticeEvent.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.special.noticeEvent.domain.NoticeEvent;
import com.alone.special.noticeEvent.domain.PageInfo;
import com.alone.special.noticeEvent.service.NoticeEventService;
import com.alone.special.noticeEvent.store.NoticeEventStore;

@Service
public class NoticeEventServiceImpl implements NoticeEventService{

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private NoticeEventStore nStore;
	@Override
	public Integer getNoticeListCount() {
		int result = nStore.selectNoticeListCount(sqlSession);
		return result;
	}
	@Override
	public List<NoticeEvent> selectNoticeList(PageInfo pInfo) {
		List<NoticeEvent> nList = nStore.selectNoticeList(sqlSession, pInfo);
		return nList;
	}
	@Override
	public Integer getEventListCount() {
		int result = nStore.selectEventListCount(sqlSession);
		return result;
	}
	@Override
	public List<NoticeEvent> selectEventList(PageInfo pInfo) {
		List<NoticeEvent> eList = nStore.selectEventList(sqlSession, pInfo);
		return eList;
	}
	@Override
	public int getNoticeListCount(String searchKeyword) {
		int result = nStore.getNoticeListCount(sqlSession, searchKeyword);
		return result;
	}
	@Override
	public List<NoticeEvent> searchNoticeByKeyword(PageInfo pInfo, String searchKeyword) {
		List<NoticeEvent> sList = nStore.searchNoticeByKeyword(sqlSession, pInfo, searchKeyword);
		return sList;
	}
	@Override
	public int getEventListCount(String searchKeyword) {
		int result = nStore.getEventListCount(sqlSession, searchKeyword);
		return result;
	}
	@Override
	public List<NoticeEvent> searchEventByKeyword(PageInfo pInfo, String searchKeyword) {
		List<NoticeEvent> sList = nStore.searchEventByKeyword(sqlSession, pInfo, searchKeyword);
		return sList;
	}
	@Override
	public NoticeEvent selectNoticeByNo(Integer boardNo) {
		NoticeEvent noticeOne = nStore.selectNoticeByNo(sqlSession, boardNo);
		return noticeOne;
	}
	@Override
	public int deleteNotice(Integer boardNo) {
		int result = nStore.deleteNotice(sqlSession, boardNo);
		return result;
	}
	@Override
	public int insertNoticeEvent(NoticeEvent noticeEvent) {
		int result = nStore.insertNoticeEvent(sqlSession, noticeEvent);
		return result;
	}
	@Override
	public int modifyNoticeEvent(NoticeEvent noticeEvent) {
		int result = nStore.modifyNoticeEvent(sqlSession, noticeEvent);
		return result;
	}
	
}
