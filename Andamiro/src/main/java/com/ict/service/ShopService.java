package com.ict.service;

import java.util.List;
import java.util.Map;

import com.ict.domain.CartVO;
import com.ict.domain.PagingVO;
import com.ict.domain.ProductVO;

public interface ShopService {
	/* Pspec 별로 상품 정보 가져오기 */
	public List<ProductVO> selectByPspec(String pspec);

	/* 카테고리별 상품정보 가져오기 */
	public List<ProductVO> selectByCategory(int cg_num_fk, PagingVO paging);

	/** 상품번호로 특정 상품 정보 가져오기 */
	public ProductVO selectByPnum(int pnum);

	public List<CartVO> selectCartView(int idx_fk);

	public int addCart(CartVO cartVo);

	public int delCart(int cartNum);

	public int editCart(CartVO cvo);

	int delCartAll(CartVO cartVo);

	int delCartOrder(Map<String, Integer> map);

	int getCartCountByIdx(CartVO cartVo);

	CartVO getCartTotal(int midx_fk);// 특정 회원의 장바구니 총액,총포인트 구하기

	public int getTotalCountByCate(int cg_num_fk);
	
	public void delCartByOrder(int midx_fk, int pnum);

}
