package com.ict.service;

import java.util.List;
import java.util.Map;

import com.ict.domain.CartVO;
import com.ict.domain.PagingVO;
import com.ict.domain.ProductVO;

public interface ShopService {
	/* Pspec ���� ��ǰ ���� �������� */
	public List<ProductVO> selectByPspec(String pspec);

	/* ī�װ��� ��ǰ���� �������� */
	public List<ProductVO> selectByCategory(int cg_num_fk, PagingVO paging);

	/** ��ǰ��ȣ�� Ư�� ��ǰ ���� �������� */
	public ProductVO selectByPnum(int pnum);

	public List<CartVO> selectCartView(int idx_fk);

	public int addCart(CartVO cartVo);

	public int delCart(int cartNum);

	public int editCart(CartVO cvo);

	int delCartAll(CartVO cartVo);

	int delCartOrder(Map<String, Integer> map);

	int getCartCountByIdx(CartVO cartVo);

	CartVO getCartTotal(int midx_fk);// Ư�� ȸ���� ��ٱ��� �Ѿ�,������Ʈ ���ϱ�

	public int getTotalCountByCate(int cg_num_fk);
	
	public void delCartByOrder(int midx_fk, int pnum);

}
