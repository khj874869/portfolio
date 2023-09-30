package com.alone.special.admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.special.admin.domain.Singo;
import com.alone.special.admin.service.AdminService;
import com.alone.special.admin.store.AdminStore;
import com.alone.special.hobby.domain.Board;
import com.alone.special.hobby.domain.Reply;
import com.alone.special.noticeEvent.domain.PageInfo;
import com.alone.special.review.domain.Review;
import com.alone.special.review.domain.ReviewPageInfo;
import com.alone.special.securitycomment.domain.Comment;
import com.alone.special.user.domain.User;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private AdminStore aStore;
	@Override
	public Integer getSingoListCount() {
		int result = aStore.getSingoListCount(sqlSession);
		return result;
	}
	@Override
	public List<Singo> selectSingoList(PageInfo pInfo) {
		List<Singo> sList = aStore.selectSingoList(sqlSession, pInfo);
		return sList;
	}
	@Override
	public int deleteSingo(Integer singoNo) {
		int result = aStore.deleteSingo(sqlSession, singoNo);
		return result;
	}
	@Override
	public Integer getSingoListCount(String searchKeyword) {
		int result = aStore.getSingoListCount(sqlSession, searchKeyword);
		return result;
	}
	@Override
	public List<Singo> selectSingoList(PageInfo pInfo, String searchKeyword) {
		List<Singo> sList = aStore.selectSingoList(sqlSession, pInfo, searchKeyword);
		return sList;
	}
	@Override
	public int insertSingo(Singo singo) {
		int result = aStore.insertSingo(sqlSession, singo);
		return result;
	}
	@Override
	public List<Review> getAllReviews(PageInfo pInfo) {
		List<Review> rList = aStore.getAllReviews(sqlSession, pInfo);
		return rList;
	}
	@Override
	public Integer selectReviewListCountByKeyword(String searchKeyword) {
		int result = aStore.selectReviewListCountByKeyword(sqlSession, searchKeyword);
		return result;
	}
	@Override
	public List<Review> getAllReviewsByKeyword(PageInfo pInfo, String searchKeyword) {
		List<Review> sList = aStore.getAllReviewsByKeyword(sqlSession, pInfo, searchKeyword);
		return sList;
	}
	@Override
	public Integer getUserListCount() {
		int result = aStore.getUserListCount(sqlSession);
		return result;
	}
	@Override
	public List<User> selectUserList(PageInfo pInfo) {
		List<User> uList = aStore.selectUserList(sqlSession, pInfo);
		return uList;
	}
	@Override
	public Integer getUserListCount(String searchKeyword) {
		int result = aStore.getUserListCountByKeyword(sqlSession, searchKeyword);
		return result;
	}
	@Override
	public List<User> selectUserList(PageInfo pInfo, String searchKeyword) {
		List<User> uList = aStore.searchUserByKeyword(sqlSession, pInfo, searchKeyword);
		return uList;
	}
	@Override
	public Integer getHReplyListCount() {
		int result = aStore.getHReplyListCount(sqlSession);
		return result;
	}
	@Override
	public List<Reply> getHReplyList(PageInfo pInfo) {
		List<Reply> hList = aStore.getHReplyList(sqlSession, pInfo);
		return hList;
	}
	@Override
	public Integer getSReplyListCount() {
		int result = aStore.getSReplyListCount(sqlSession);
		return result;
	}
	@Override
	public List<Comment> getSReplyList(PageInfo pInfo) {
		List<Comment> sList = aStore.getSReplyList(sqlSession, pInfo);
		return sList;
	}
	@Override
	public Integer getHReplyListCount(String searchKeyword) {
		int result = aStore.getHReplyListCount(sqlSession, searchKeyword);
		return result;
	}
	@Override
	public List<Reply> getHReplyList(PageInfo pInfo, String searchKeyword) {
		List<Reply> sList = aStore.getHReplyList(sqlSession, pInfo, searchKeyword);
		return sList;
	}
	@Override
	public Integer getSReplyListCount(String searchKeyword) {
		int result = aStore.getSReplyListCount(sqlSession, searchKeyword);
		return result;
	}
	@Override
	public List<Comment> getSReplyList(PageInfo pInfo, String searchKeyword) {
		List<Comment> sList = aStore.getSReplyList(sqlSession, pInfo, searchKeyword);
		return sList;
	}
	@Override
	public int deleteBoard(Board board) {
		int result = aStore.deleteBoardByAdmin(sqlSession, board);
		return result;
	}

}
