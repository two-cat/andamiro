package com.ict.mapper;

import java.util.List;
import java.util.Map;

import com.ict.domain.PagingVO;
import com.ict.domain.ProductVO;

public interface ProductMapper {
	public int productInsert(ProductVO item);

	public List<ProductVO> productList();

	List<ProductVO> selectByPspec(String pspec);

	ProductVO selectByPnum(Integer pnum);

	public List<ProductVO> selectByCgnum(Map<String, Object>  map);

	public int getTotalCountByCate(int cg_num_fk);
	
	public List<ProductVO> getProducts(int cg_num);
}
