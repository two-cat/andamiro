package com.ict.service;

import java.util.List;

import com.ict.domain.ReviewVO;

public interface ReviewService {
	public int insertReview(ReviewVO rvo);
	public List<ReviewVO> listReview(int  pnum_fk);
	public int deleteReview(int num);
	public int updateReview(ReviewVO Review);
}
