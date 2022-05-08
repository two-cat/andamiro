package com.ict.service;

import java.util.List;

import com.ict.domain.CenterVO;

public interface CenterService {

	public List<CenterVO> listCenter();
	
	public int deleteCetner(int idx_fk);
	
	public int getTotalCount();
	
	public int updateReadnum(int idx_fk);
	
	public CenterVO selectCenterByIdx(int sc_idx);
	
	public int insertCenter(CenterVO vo);
	
	public int updateCener(CenterVO Center);
}
