package com.alone.special.noticeEvent.service;

import java.util.List;

import com.alone.special.noticeEvent.domain.NoticeEvent;
import com.alone.special.noticeEvent.domain.PageInfo;

public interface NoticeEventService {

	/**
	 * 공지사항 전체 갯수 Service
	 * @return
	 */
	Integer getNoticeListCount();

	/**
	 * 공지사항 전체 리스트 Service
	 * @param pInfo
	 * @return
	 */
	List<NoticeEvent> selectNoticeList(PageInfo pInfo);

	/**
	 * 공지사항 검색 리스트 갯수 Service
	 * @param searchKeyword
	 * @return
	 */
	int getNoticeListCount(String searchKeyword);

	/**
	 * 공지사항 검색 리스트 Service
	 * @param pInfo
	 * @param searchKeyword
	 * @return
	 */
	List<NoticeEvent> searchNoticeByKeyword(PageInfo pInfo, String searchKeyword);

	/**
	 * 공지사항 상세 조회 Service
	 * @param boardNo
	 * @return
	 */
	NoticeEvent selectNoticeByNo(Integer boardNo);

	/**
	 * 공지사항 삭제 Service
	 * @param boardNo
	 * @return
	 */
	int deleteNotice(Integer boardNo);

	/**
	 * 공지사항/행사 등록 Service
	 * @param noticeEvent
	 * @param boardType
	 * @return
	 */
	int insertNoticeEvent(NoticeEvent noticeEvent);

	/**
	 * 공지사항/행사 수정 Service
	 * @param noticeEvent
	 * @return
	 */
	int modifyNoticeEvent(NoticeEvent noticeEvent);

	/**
	 * 행사 전체 갯수 Service
	 * @return
	 */
	Integer getEventListCount();

	/**
	 * 행사 전체 리스트 Service
	 * @param pInfo
	 * @return
	 */
	List<NoticeEvent> selectEventList(PageInfo pInfo);

	/**
	 * 행사 검색 리스트 갯수 Service
	 * @param searchKeyword
	 * @return
	 */
	int getEventListCount(String searchKeyword);

	/**
	 * 행사 검색 리스트 Service
	 * @param pInfo
	 * @param searchKeyword
	 * @return
	 */
	List<NoticeEvent> searchEventByKeyword(PageInfo pInfo, String searchKeyword);

}
