package com.ratseno.board.board.mapper;

import java.util.List;

import com.ratseno.board.board.model.req.ReplyReq;
import com.ratseno.board.board.model.res.ReplyRes;
import com.ratseno.board.common.annotation.Mapper;

@Mapper
public interface ReplyMapper {

	/*댓글 등록*/
	public int insertReply(ReplyReq replyReq)throws Exception;
	
	/*댓글 목록 조회*/
	public List<ReplyRes> selectReplyList(ReplyReq replyReq)throws Exception;
	
	/*댓글 갯수 조회*/
	public int selectReplyCnt(ReplyReq replyReq);
	
	/*댓글 수정*/
	public int updateReply(ReplyReq replyReq)throws Exception;
	
	/*댓글 삭제*/
	public int deleteReply(Integer reply_no);
	
	/*게시물 하위 댓글 전체 삭제*/
	public int deleteReplyByBoardNo(Integer board_no);
}
