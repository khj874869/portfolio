package com.alone.special.hobby.service;

import java.util.List;

import com.alone.special.hobby.domain.Reply;

public interface ReplyService {

	int insertReply(Reply reply);

	int updateReply(Reply reply);

	int deleteReply(Reply reply);

	List<Reply> selectReplyList(Integer refBoardNo);

	int getReplyCount(Integer hBoardNo);

	int deleteReplyByBoardNo(Integer hBoardNo);

}
