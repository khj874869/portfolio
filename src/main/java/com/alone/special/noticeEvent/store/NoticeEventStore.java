package com.alone.special.noticeEvent.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alone.special.noticeEvent.domain.NoticeEvent;
import com.alone.special.noticeEvent.domain.PageInfo;

public interface NoticeEventStore {

	/**
	 * 공지사항 전체 갯수 조회 Store
	 * @param sqlSession
	 * @return
	 */
	int selectNoticeListCount(SqlSession sqlSession);

	/**
	 * 공지사항 전체 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @return
	 */
	List<NoticeEvent> selectNoticeList(SqlSession sqlSession, PageInfo pInfo);

	/**
	 * 공지사항 검색 리스트 갯수 Store
	 * @param sqlSession
	 * @param searchKeyword
	 * @return
	 */
	int getNoticeListCount(SqlSession sqlSession, String searchKeyword);

	/**
	 * 공지사항 검색 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @param searchKeyword
	 * @return
	 */
	List<NoticeEvent> searchNoticeByKeyword(SqlSession sqlSession, PageInfo pInfo, String searchKeyword);

	/**
	 * 공지사항 상세 조회 Store
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 */
	NoticeEvent selectNoticeByNo(SqlSession sqlSession, Integer boardNo);

	/**
	 * 공지사항 삭제 Store
	 * @param sqlSession
	 * @param boardNo
	 * @return
	 */
	int deleteNotice(SqlSession sqlSession, Integer boardNo);

	/**
	 * 공지사항/행사 등록 Store
	 * @param sqlSession
	 * @param noticeEvent
	 * @param boardType
	 * @return
	 */
	int insertNoticeEvent(SqlSession sqlSession, NoticeEvent noticeEvent);

	/**
	 * 공지사항/행사 수정 Store
	 * @param sqlSession
	 * @param noticeEvent
	 * @return
	 */
	int modifyNoticeEvent(SqlSession sqlSession, NoticeEvent noticeEvent);

	/**
	 * 행사 전체 갯수 조회 Store
	 * @param sqlSession
	 * @return
	 */
	int selectEventListCount(SqlSession sqlSession);

	/**
	 * 행사 전체 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @return
	 */
	List<NoticeEvent> selectEventList(SqlSession sqlSession, PageInfo pInfo);

	/**
	 * 행사 검색 리스트 갯수 Store
	 * @param sqlSession
	 * @param searchKeyword
	 * @return
	 */
	int getEventListCount(SqlSession sqlSession, String searchKeyword);

	/**
	 * 행사 검색 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @param searchKeyword
	 * @return
	 */
	List<NoticeEvent> searchEventByKeyword(SqlSession sqlSession, PageInfo pInfo, String searchKeyword);

}
