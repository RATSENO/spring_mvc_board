package com.ratseno.board.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratseno.board.board.mapper.ReplyMapper;
import com.ratseno.board.board.model.req.ReplyReq;
import com.ratseno.board.board.model.res.ReplyListRes;
import com.ratseno.board.board.model.res.ReplyRes;
import com.ratseno.board.board.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	ReplyMapper replyMapper;

	/*댓글 등록*/
	@Override
	public void replyRegist(ReplyReq replyReq) throws Exception {
		int regCnt = replyMapper.insertReply(replyReq);
	}

	/*댓글 목록 조회*/
	@Override
	public ReplyListRes replyList(Integer board_no) throws Exception {
		ReplyListRes replyListRes = new ReplyListRes();
		
		List<ReplyRes> replyList = null;
		replyList = replyMapper.selectReplyList(board_no);
		
		if(!replyList.isEmpty()) {
			replyListRes.setReplyList(replyList);
		}
		return replyListRes;
	}

	/*댓글 수정*/
	@Override
	public void modifyReply(ReplyReq replyReq) throws Exception {
		int modCnt = replyMapper.updateReply(replyReq);
	}

	/*댓글 삭제*/
	@Override
	public void deleteReply(Integer reply_no) throws Exception {
		int delCnt = replyMapper.deleteReply(reply_no);
	}

}
