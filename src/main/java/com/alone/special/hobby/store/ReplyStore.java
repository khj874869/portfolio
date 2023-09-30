package com.alone.special.hobby.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alone.special.hobby.domain.Reply;

public interface ReplyStore {

	int insertReply(SqlSession session, Reply reply);

	int updateReply(SqlSession session, Reply reply);

	int deleteReply(SqlSession session, Reply reply);

	List<Reply> selectReplyList(SqlSession session, Integer refBoardNo);

	int getReplyCount(SqlSession session, Integer hBoardNo);

	int deleteReplyByBoardNo(SqlSession session, Integer hBoardNo);

}
