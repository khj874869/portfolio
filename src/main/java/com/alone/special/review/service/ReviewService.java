package com.alone.special.review.service;

import java.util.List;

import com.alone.special.review.domain.Review;
import com.alone.special.review.domain.ReviewPageInfo;

public interface ReviewService {

	Review selectOne(Integer sReviewId);

	List<Review> getProductReviews(Integer sProductId, ReviewPageInfo rInfo);

	int insertReview(Review review);

	int getListCount();

	int updatelike(Integer reviewId);

	int editReview(Review review);

	int deletereview(Integer reviewId);


}
