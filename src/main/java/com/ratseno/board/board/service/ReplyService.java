package com.ratseno.board.board.service;

import com.ratseno.board.board.model.req.ReplyReq;
import com.ratseno.board.board.model.res.ReplyListRes;

public interface ReplyService {
	
	/*댓글 등록*/
	public void replyRegist(ReplyReq replyReq)throws Exception;
	
	/*댓글 목록 조회*/
	public ReplyListRes replyList(Integer board_no)throws Exception;
	
	/*댓글 수정*/
	public void modifyReply(ReplyReq replyReq)throws Exception;
	
	/*댓글 삭제*/
	public void deleteReply(Integer reply_no)throws Exception;

	
}
