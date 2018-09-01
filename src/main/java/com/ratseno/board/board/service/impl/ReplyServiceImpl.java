package com.ratseno.board.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratseno.board.board.mapper.ReplyMapper;
import com.ratseno.board.board.model.req.ReplyReq;
import com.ratseno.board.board.model.res.ReplyListRes;
import com.ratseno.board.board.model.res.ReplyRes;
import com.ratseno.board.board.service.ReplyService;
import com.ratseno.board.common.model.PageInfo;

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
	public ReplyListRes replyList(ReplyReq replyReq) throws Exception {
		ReplyListRes res = new ReplyListRes();
		PageInfo pageInfo = new PageInfo();
		replyReq.setCurPageNo();
		
		List<ReplyRes> replyList = replyMapper.selectReplyList(replyReq);
		int replyCnt = replyMapper.selectReplyCnt(replyReq);
		
		if(replyCnt ==0 && replyList.isEmpty()) {
			res.setReplyList(null);
		}
		
		pageInfo.setPage_no(replyReq.getPage_no());
		pageInfo.setPage_size(replyReq.getPage_size());
		pageInfo.setPage_result_count(replyList.size());
		pageInfo.setTotal_count(replyCnt);
		
		res.setPageInfo(pageInfo);
		res.setReplyList(replyList);
		
		return res;
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
