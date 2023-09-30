package com.alone.special.hobby.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.special.hobby.domain.Reply;
import com.alone.special.hobby.service.ReplyService;
import com.alone.special.hobby.store.ReplyStore;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyStore rStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertReply(Reply reply) {
		int result = rStore.insertReply(session, reply);
		return result;
	}

	@Override
	public int updateReply(Reply reply) {
		int result = rStore.updateReply(session, reply);
		return result;
	}

	@Override
	public int deleteReply(Reply reply) {
		int result = rStore.deleteReply(session, reply);
		return result;
	}

	@Override
	public List<Reply> selectReplyList(Integer refBoardNo) {
		List<Reply> rList = rStore.selectReplyList(session, refBoardNo);
		return rList;
	}

	@Override
	public int getReplyCount(Integer hBoardNo) {
		int replyTotalCount = rStore.getReplyCount(session, hBoardNo);
		return replyTotalCount;
	}

	@Override
	public int deleteReplyByBoardNo(Integer hBoardNo) {
		int result = rStore.deleteReplyByBoardNo(session, hBoardNo);
		return result;
	}
	
}
