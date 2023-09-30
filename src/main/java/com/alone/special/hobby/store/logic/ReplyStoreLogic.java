package com.alone.special.hobby.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.alone.special.hobby.domain.Reply;
import com.alone.special.hobby.store.ReplyStore;

@Repository
public class ReplyStoreLogic implements ReplyStore {

	@Override
	public int insertReply(SqlSession session, Reply reply) {
		int result = session.insert("ReplyMapper.insertReply", reply);
		return result;
	}

	@Override
	public int updateReply(SqlSession session, Reply reply) {
		int result = session.update("ReplyMapper.updateReply", reply);
		return result;
	}

	@Override
	public int deleteReply(SqlSession session, Reply reply) {
		int result = session.update("ReplyMapper.deleteReply", reply);
		return result;
	}

	@Override
	public List<Reply> selectReplyList(SqlSession session, Integer refBoardNo) {
		List<Reply> rList = session.selectList("ReplyMapper.selectReplyList", refBoardNo);
		return rList;
	}

	@Override
	public int getReplyCount(SqlSession session, Integer hBoardNo) {
		int replyTotalCount = session.selectOne("ReplyMapper.getReplyCount", hBoardNo);
		return replyTotalCount;
	}

	@Override
	public int deleteReplyByBoardNo(SqlSession session, Integer hBoardNo) {
		int result = session.delete("ReplyMapper.deleteReplyByBoardNo", hBoardNo);
		return result;
	}

}
