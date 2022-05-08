package com.ict.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.domain.CategoryVO;
import com.ict.domain.OrderVO;
import com.ict.domain.ProductVO;
import com.ict.mapper.CategoryMapper;
import com.ict.mapper.ProductMapper;
@Service(value="adminServiceImpl")
public class AdminServiceImpl implements AdminService {
	
	@Inject
	private CategoryMapper categoryMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	
	@Override
	public List<CategoryVO> getCategoryList() {
		// TODO Auto-generated method stub
		return categoryMapper.categoryAll();
	}

	@Override
	public int categoryAdd(CategoryVO cvo) {
		// TODO Auto-generated method stub
		return categoryMapper.insertCategory(cvo);
	}

	@Override
	public int categoryDelete(int cg_num) {
		// TODO Auto-generated method stub
		return categoryMapper.deleteCategory(cg_num);
	}

	@Override
	public int productInsert(ProductVO prod) {
		
		return this.productMapper.productInsert(prod);
	}

	@Override
	public List<ProductVO> productList() {
		
		return this.productMapper.productList();
	}

	@Override
	public void manageOrder(String onum, String colName, String colVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OrderVO> getOrderListByMonth(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	@Override
	public List<ProductVO> getProducts(int cg_num) {
		// TODO Auto-generated method stub
		return this.productMapper.getProducts(cg_num);
	}

}
