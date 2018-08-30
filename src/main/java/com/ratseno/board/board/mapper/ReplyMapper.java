package com.ratseno.board.board.mapper;

import java.util.List;

import com.ratseno.board.board.model.req.ReplyReq;
import com.ratseno.board.board.model.res.ReplyRes;

public interface ReplyMapper {

	/*댓글 등록*/
	public int insertReply(ReplyReq replyReq)throws Exception;
	
	/*댓글 목록 조회*/
	public List<ReplyRes> selectReplyList(Integer board_no)throws Exception;
	
	/*댓글 수정*/
	public int updateReply(ReplyReq replyReq)throws Exception;
	
	/*댓글 삭제*/
	public int deleteReply(Integer reply_no);
}
