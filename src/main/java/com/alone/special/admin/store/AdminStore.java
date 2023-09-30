package com.alone.special.admin.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alone.special.admin.domain.Singo;
import com.alone.special.hobby.domain.Board;
import com.alone.special.hobby.domain.Reply;
import com.alone.special.noticeEvent.domain.PageInfo;
import com.alone.special.review.domain.Review;
import com.alone.special.review.domain.ReviewPageInfo;
import com.alone.special.securitycomment.domain.Comment;
import com.alone.special.user.domain.User;

public interface AdminStore {

	/**
	 * 신고 회원 수 Store
	 * @param sqlSession
	 * @return
	 */
	int getSingoListCount(SqlSession sqlSession);

	/**
	 * 신고 회원 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @return
	 */
	List<Singo> selectSingoList(SqlSession sqlSession, PageInfo pInfo);

	/**
	 * 신고 취소 Store
	 * @param sqlSession
	 * @param singoNo
	 * @return
	 */
	int deleteSingo(SqlSession sqlSession, Integer singoNo);

	/**
	 * 신고 회원 검색 수 Store
	 * @param sqlSession
	 * @param searchKeyword
	 * @return
	 */
	int getSingoListCount(SqlSession sqlSession, String searchKeyword);

	/**
	 * 신고 회원 검색 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @param searchKeyword
	 * @return
	 */
	List<Singo> selectSingoList(SqlSession sqlSession, PageInfo pInfo, String searchKeyword);

	/**
	 * 신고 등록 Store
	 * @param sqlSession
	 * @param singo
	 * @return
	 */
	int insertSingo(SqlSession sqlSession, Singo singo);

	/**
	 * 안전 리뷰 전체 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @return
	 */
	List<Review> getAllReviews(SqlSession sqlSession, PageInfo pInfo);

	/**
	 * 안전 리뷰 검색 갯수 조회 Store
	 * @param sqlSession
	 * @param searchKeyword
	 * @return
	 */
	int selectReviewListCountByKeyword(SqlSession sqlSession, String searchKeyword);

	/**
	 * 안전 리뷰 검색 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @param searchKeyword
	 * @return
	 */
	List<Review> getAllReviewsByKeyword(SqlSession sqlSession, PageInfo pInfo, String searchKeyword);

	/**
	 * 전체 회원 수 조회 Store
	 * @param sqlSession
	 * @return
	 */
	int getUserListCount(SqlSession sqlSession);

	/**
	 * 전체 회원 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @return
	 */
	List<User> selectUserList(SqlSession sqlSession, PageInfo pInfo);

	/**
	 * 검색 회원 수 조회 Store
	 * @param sqlSession
	 * @param searchKeyword
	 * @return
	 */
	int getUserListCountByKeyword(SqlSession sqlSession, String searchKeyword);

	/**
	 * 검색 회원 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @param searchKeyword
	 * @return
	 */
	List<User> searchUserByKeyword(SqlSession sqlSession, PageInfo pInfo, String searchKeyword);

	/**
	 * 취미 댓글 전체 수 Store
	 * @param sqlSession
	 * @return
	 */
	int getHReplyListCount(SqlSession sqlSession);

	/**
	 * 취미 댓글 전체 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @return
	 */
	List<Reply> getHReplyList(SqlSession sqlSession, PageInfo pInfo);

	/**
	 * 안전 댓글 전체 수 Store
	 * @param sqlSession
	 * @return
	 */
	int getSReplyListCount(SqlSession sqlSession);

	/**
	 * 안전 댓글 전체 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @return
	 */
	List<Comment> getSReplyList(SqlSession sqlSession, PageInfo pInfo);

	/**
	 * 취미 댓글 검색 수 Store
	 * @param sqlSession
	 * @param searchKeyword
	 * @return
	 */
	int getHReplyListCount(SqlSession sqlSession, String searchKeyword);

	/**
	 * 취미 댓글 검색 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @param searchKeyword
	 * @return
	 */
	List<Reply> getHReplyList(SqlSession sqlSession, PageInfo pInfo, String searchKeyword);

	/**
	 * 안전 댓글 검색 수 Store
	 * @param sqlSession
	 * @param searchKeyword
	 * @return
	 */
	int getSReplyListCount(SqlSession sqlSession, String searchKeyword);

	/**
	 * 안전 댓글 검색 리스트 Store
	 * @param sqlSession
	 * @param pInfo
	 * @param searchKeyword
	 * @return
	 */
	List<Comment> getSReplyList(SqlSession sqlSession, PageInfo pInfo, String searchKeyword);

	/**
	 * 취미 게시판 삭제 Store
	 * @param sqlSession
	 * @param board
	 * @return
	 */
	int deleteBoardByAdmin(SqlSession sqlSession, Board board);


}
