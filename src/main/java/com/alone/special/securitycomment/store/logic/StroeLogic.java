package com.alone.special.securitycomment.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alone.special.securitycomment.domain.Comment;
import com.alone.special.securitycomment.store.Store;

@Repository
public class StroeLogic implements Store{

	@Autowired
	private SqlSession session;

	@Override
	public int insertComment(Comment comment, SqlSession session) {
		int result = session.insert("CommentMapper.insertComment",comment);
		return result;
	}

	@Override
	public List<Comment> searchComment(Map<String, String> paramMap, SqlSession session) {
		List<Comment> comment=session.selectList("CommentMapper.selectCommentByKeyword", paramMap);
		return comment;
	}

	@Override
	public List<Comment> commentList(SqlSession session) {
		List<Comment> comment = session.selectList("CommentMapper.allListComment");
		return comment;
	}

	@Override
	public int deletecomment(Integer sCommentNo, SqlSession session) {
		int result = session.delete("CommentMapper.deleteComment", sCommentNo);
		return result;
	}

	@Override
	public int updaterecommnd(Integer sCommentNo) {
		int result = session.update("CommentMapper.CommentLikeIncrement", sCommentNo);
		return result;
	}

	@Override
	public int updateComment(Comment comment, SqlSession session) {
		int result = session.update("CommentMapper.updateComment",comment);
		return result;
	}
	
	
}
