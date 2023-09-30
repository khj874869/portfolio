package com.alone.special.review.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.special.review.domain.Review;
import com.alone.special.review.domain.ReviewPageInfo;
import com.alone.special.review.service.ReviewService;
import com.alone.special.review.store.ReviewStore;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private SqlSession session;
	@Autowired
	private ReviewStore store;
	@Override
	public List<Review> getProductReviews(Integer sProductId,ReviewPageInfo rInfo) {
		List<Review> reviewlist= store.getReviewList(sProductId,session,rInfo);
		
		return reviewlist;
	}
	@Override
	public int insertReview(Review review) {
		int result = store.insertReview(review,session);
		return result;
	}
	@Override
	public int getListCount() {
		int result =store.selectReviewListCount(session);
		return result;
	}
	@Override
	public int updatelike(Integer commentId) {

		int result = store.updateRecomment(session,commentId);
		return result;
	}
	@Override
	public int editReview(Review review) {
		int result = store.editReview(session,review);
		return result;
	}
	@Override
	public int deletereview(Integer reviewId) {
		int result = store.deleteReview(session,reviewId);
		return result;
	}
	@Override
	public Review selectOne(Integer sReviewId) {
		Review review = store.selectReviewOne(session,sReviewId);
		return review;
	}
	
}
