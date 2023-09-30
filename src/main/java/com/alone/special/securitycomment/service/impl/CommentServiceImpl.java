package com.alone.special.securitycomment.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.special.product.domain.Product;
import com.alone.special.securitycomment.domain.Comment;
import com.alone.special.securitycomment.service.CommentService;
import com.alone.special.securitycomment.store.Store;

@Service
public class CommentServiceImpl implements CommentService{

	
	@Autowired
	private SqlSession session;
	@Autowired
	private Store commentstore;
	@Override
	public int insertComment(Comment comment) {
		int result = commentstore.insertComment(comment,session);
		return result;
	}
	@Override
	public List<Comment> searchCommentsByKeyword(Map<String, String> paramMap) {
		List<Comment> comment = commentstore.searchComment(paramMap,session);
		return comment;
	}
	@Override
	public List<Comment> getCommentList() {
		List<Comment> comment = commentstore.commentList(session);
		return comment;
	}
	@Override
	public int deleteComment(Integer sCommentNo) {
		int result = commentstore.deletecomment(sCommentNo,session);
		return result;
	}
	@Override
	public int updatelike(Integer sCommentNo) {
		int result =commentstore.updaterecommnd(sCommentNo);
		return 0;
	}
	@Override
	public int editComment(Comment comment) {
		int result = commentstore.updateComment(comment,session);
		return result;
	}

}
