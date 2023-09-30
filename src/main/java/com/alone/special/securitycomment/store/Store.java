package com.alone.special.securitycomment.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.alone.special.securitycomment.domain.Comment;

public interface Store {

	int insertComment(Comment comment, SqlSession session);

	List<Comment> searchComment(Map<String, String> paramMap, SqlSession session);

	List<Comment> commentList(SqlSession session);

	int deletecomment(Integer sCommentNo, SqlSession session);

	int updaterecommnd(Integer sCommentNo);

	int updateComment(Comment comment, SqlSession session);

	
}
