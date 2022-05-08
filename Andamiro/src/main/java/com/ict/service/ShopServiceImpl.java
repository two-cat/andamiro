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
		// [1] 상품번호와 회원번호로 cart테이블에 있는 상품개수 가져오기
		int count=cartMapper.selectCartByPnum(cartVo);
		System.out.println("count=" + count);
		// [2] 해당상품이 이미 존재 한다면 수량만 추가
		int n = 0;
		if(count > 0) {
			n = cartMapper.updateCartOqty(cartVo);
		}else {
		// [3] 해당 상품이 장바구니에 없는 상품이라면 insert
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
		// 수량에 따라 다르게 로직 처리하기
		int qty = cartVo.getOqty();
		if(qty == 0) { // 수정이 0이면 삭제 처리
			return this.delCart(cartVo.getCartNum());
		}else if(qty < 0) {
			throw new NumberFormatException("수량은 음수여선 안됩니다.");
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
