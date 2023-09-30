package com.alone.special.review.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alone.special.product.domain.Product;
import com.alone.special.review.domain.Review;
import com.alone.special.review.domain.ReviewPageInfo;
import com.alone.special.review.store.ReviewStore;

@Repository
public class ReviewStoreLogic implements ReviewStore{
	@Autowired
	private SqlSession session;

	@Override
	public List<Review> getReviewList(Integer sProductId, SqlSession session,ReviewPageInfo rInfo) {
		int limit = rInfo.getRecordCountPerPage();
		int offset = (rInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<Review> reviews =session.selectList("ReviewMapper.getProductReviews", sProductId,rowBounds);
		return reviews;
	}

	@Override
	public int insertReview(Review review, SqlSession session) {
		int result = session.insert("ReviewMapper.insertReview", review);
		return result;
	}

	@Override
	public int selectReviewListCount(SqlSession session) {
		int result = session.selectOne("ReviewMapper.selectReviewListCount");
		return result;
	}


	@Override
	public int updateRecomment(SqlSession session, Integer commentId) {

		int result = session.update("ReviewMapper.incrementReviewLikeCount",commentId);
		return result;
	}

	@Override
	public int editReview(SqlSession session, Review review) {
		int result = session.update("ReviewMapper.editReview",review);
		return result;
	}

	@Override
	public int deleteReview(SqlSession session, Integer reviewId) {
		int result = session.delete("ReviewMapper.deleteReview",reviewId);
		return result;
	}

	@Override
	public Review selectReviewOne(SqlSession session, Integer sReviewId) {
		Review review = session.selectOne("ReviewMapper.singoReview", sReviewId);
		return review;
	}
}
