package com.ict.mapper;

import java.util.List;

import com.ict.domain.CategoryVO;

public interface CategoryMapper {
	
	

	public int categoryDelete(int cg_num);
	
	public List<CategoryVO> categoryAll();

	public int insertCategory(CategoryVO cvo);

	public int deleteCategory(int cg_num);
	
}
