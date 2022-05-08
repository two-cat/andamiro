package com.ict.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ict.domain.CenterVO;
import com.ict.mapper.CenterMapper;

@Service
public class CenterServiceImpl implements CenterService {

	@Inject
	private CenterMapper centerMapper;
	@Override
	public List<CenterVO> listCenter() {
		
		return this.centerMapper.listCenter();
	}

	@Override
	public int deleteCetner(int idx_fk) {
		// TODO Auto-generated method stub
		return this.centerMapper.deleteCetner(idx_fk);
	}

	@Override
	public int getTotalCount() {
		
		return this.centerMapper.getTotalCount();
	}

	@Override
	public int updateReadnum(int idx_fk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CenterVO selectCenterByIdx(int sc_idx) {
		
		return this.centerMapper.selectCenterByIdx(sc_idx);
	}

	@Override
	public int insertCenter(CenterVO vo) {
		
		return this.centerMapper.insertCenter(vo);
	}

	@Override
	public int updateCener(CenterVO Center) {
		
		return this.centerMapper.updateCener(Center);
	}

}
