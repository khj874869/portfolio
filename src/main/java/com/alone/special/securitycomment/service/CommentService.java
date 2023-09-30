package com.alone.special.securitycomment.service;

import java.util.List;
import java.util.Map;

import com.alone.special.securitycomment.domain.Comment;

public interface CommentService {

	int insertComment(Comment comment);

	List<Comment> searchCommentsByKeyword(Map<String, String> paramMap);

	List<Comment> getCommentList();

	int deleteComment(Integer sCommentNo);

	int updatelike(Integer sCommentNo);

	int editComment(Comment comment);

}
