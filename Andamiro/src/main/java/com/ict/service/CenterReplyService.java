package com.ict.service;

import java.util.List;

import com.ict.domain.CenterReplyVO;

public interface CenterReplyService {
	
	public int insertReply(CenterReplyVO crvo);
	
	public List<CenterReplyVO> listReply(int sc_idx);
	
	public int deleteReply(int cr_idx);
}
