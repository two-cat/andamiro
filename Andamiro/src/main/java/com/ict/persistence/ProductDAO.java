package com.ict.persistence;

import java.util.List;

import com.ict.domain.ProductVO;

public interface ProductDAO {
	
	public int productInsert(ProductVO item);
	
	public List<ProductVO> productList();
	
	List<ProductVO> selectByPspec(String pspec);
	
	List<ProductVO> selectByCgnum(int cg_num_fk);

	ProductVO selectByPnum(Integer pnum);

}
