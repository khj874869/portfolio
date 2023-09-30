package com.alone.special.review.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alone.special.review.domain.Review;
import com.alone.special.review.domain.ReviewPageInfo;

public interface ReviewStore {

	List<Review> getReviewList(Integer sProductId, SqlSession session, ReviewPageInfo rInfo);

	int insertReview(Review review, SqlSession session);

	int selectReviewListCount(SqlSession session);

	Review selectReviewOne(SqlSession session, Integer sReviewId);

	int updateRecomment(SqlSession session, Integer commentId);

	int editReview(SqlSession session, Review review);

	int deleteReview(SqlSession session, Integer reviewId);


}
