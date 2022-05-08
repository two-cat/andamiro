package com.ict.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ict.domain.CenterReplyVO;
import com.ict.mapper.CenterReplyMapper;

@Service
public class CenterReplyServiceImpl implements CenterReplyService {

	@Inject
	private CenterReplyMapper crMapper;
	@Override
	public int insertReply(CenterReplyVO crvo) {
		// TODO Auto-generated method stub
		return this.crMapper.insertReply(crvo);
	}

	@Override
	public List<CenterReplyVO> listReply(int sc_idx) {
		// TODO Auto-generated method stub
		return this.crMapper.listReply(sc_idx);
	}

	@Override
	public int deleteReply(int cr_idx) {
		// TODO Auto-generated method stub
		return this.crMapper.deleteReply(cr_idx);
	}

}
