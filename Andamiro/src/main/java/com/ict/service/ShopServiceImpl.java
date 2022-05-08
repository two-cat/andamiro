package com.ict.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ict.domain.CartVO;
import com.ict.domain.PagingVO;
import com.ict.domain.ProductVO;
import com.ict.mapper.CartMapper;
import com.ict.mapper.ProductMapper;

@Service("shopServiceImpl")
public class ShopServiceImpl implements ShopService {

	@Inject
	private ProductMapper prodMapper;
	
	@Inject
	private CartMapper cartMapper;
	@Override
	public List<ProductVO> selectByPspec(String pspec) {
		// TODO Auto-generated method stub
		return prodMapper.selectByPspec(pspec);
	}

	@Override
	   public List<ProductVO> selectByCategory(int cg_num_fk,PagingVO page) {
		Map<String, Object> map=new HashMap<>();
		map.put("cg_num", cg_num_fk);
		map.put("page", page);
	      return prodMapper.selectByCgnum(map);
	   }

	@Override
	public ProductVO selectByPnum(int pnum) {
		
		return prodMapper.selectByPnum(pnum);
	}

	@Override
	public List<CartVO> selectCartView(int idx_fk) {
		
		return this.cartMapper.selectCartView(idx_fk);
	}

	@Override
	public int addCart(CartVO cartVo) {
		// [1] ��ǰ��ȣ�� ȸ����ȣ�� cart���̺� �ִ� ��ǰ���� ��������
		int count=cartMapper.selectCartByPnum(cartVo);
		System.out.println("count=" + count);
		// [2] �ش��ǰ�� �̹� ���� �Ѵٸ� ������ �߰�
		int n = 0;
		if(count > 0) {
			n = cartMapper.updateCartOqty(cartVo);
		}else {
		// [3] �ش� ��ǰ�� ��ٱ��Ͽ� ���� ��ǰ�̶�� insert
			n = cartMapper.addCart(cartVo);
		}
		return n;
	}

	@Override
	public CartVO getCartTotal(int midx_fk) {
		return this.cartMapper.getCartTotal(midx_fk);
	}

	@Override
	public int delCart(int cartNum) {
		
		return this.cartMapper.delCart(cartNum);
	}

	@Override
	public int editCart(CartVO cartVo) {
		// ������ ���� �ٸ��� ���� ó���ϱ�
		int qty = cartVo.getOqty();
		if(qty == 0) { // ������ 0�̸� ���� ó��
			return this.delCart(cartVo.getCartNum());
		}else if(qty < 0) {
			throw new NumberFormatException("������ �������� �ȵ˴ϴ�.");
		}else{
			return this.cartMapper.editCart(cartVo);
		}
		
	}

	@Override
	public int delCartAll(CartVO cartVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delCartOrder(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCartCountByIdx(CartVO cartVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delCartByOrder(int midx_fk, int pnum) {
		Map<String,Integer> map = new HashMap<>();
		map.put("idx_fk", midx_fk);
		map.put("pnum_fk", pnum);
		
		this.cartMapper.delCartByOrder(map);

	}

	@Override
	public int getTotalCountByCate(int cg_num_fk) {
		// TODO Auto-generated method stub
		return prodMapper.getTotalCountByCate( cg_num_fk);
	}

	

}
