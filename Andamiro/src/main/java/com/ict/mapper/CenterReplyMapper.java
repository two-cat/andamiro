package com.ict.mapper;

import java.util.List;

import com.ict.domain.CenterReplyVO;

public interface CenterReplyMapper {

public int insertReply(CenterReplyVO crvo);
	
	public List<CenterReplyVO> listReply(int sc_idx);
	
	public int deleteReply(int cr_idx);
	
}
