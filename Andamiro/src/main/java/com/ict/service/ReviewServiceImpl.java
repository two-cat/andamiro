package com.ict.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ict.domain.ReviewVO;
import com.ict.mapper.ReviewMapper;

@Service("reviewServiceImpl")
public class ReviewServiceImpl implements ReviewService {
 
	
	@Inject
	private ReviewMapper reviewMapper;
	
	@Override
	public int insertReview(ReviewVO rvo) {
		// TODO Auto-generated method stub
		
		
		return reviewMapper.insertReview(rvo);
	}

	@Override
	public List<ReviewVO> listReview(int pnum_fk) {
		return reviewMapper.listReview(pnum_fk);
	}

	@Override
	public int deleteReview(int num) {
		// TODO Auto-generated method stub
		return reviewMapper.deleteReview(num);
	}

	@Override
	public int updateReview(ReviewVO Review) {
		// TODO Auto-generated method stub
		return reviewMapper.updateReview(Review);
	}

}
