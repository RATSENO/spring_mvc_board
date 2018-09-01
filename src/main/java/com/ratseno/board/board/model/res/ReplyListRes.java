package com.ratseno.board.board.model.res;

import java.util.List;

import com.ratseno.board.common.model.PageInfo;

import lombok.Data;

@Data
public class ReplyListRes {

	List<ReplyRes> replyList;
	
	PageInfo pageInfo;
	
}
