package com.ict.service;

import java.util.List;

import com.ict.domain.CategoryVO;
import com.ict.domain.OrderVO;
import com.ict.domain.ProductVO;


public interface AdminService {

	/** 카테고리 목록 가져오기 */
	List<CategoryVO> getCategoryList();
	
	public int categoryAdd(CategoryVO cvo);
	
	public int categoryDelete(int cg_num);

	/** [관리자 모드]- 상품 정보 등록하기 */
	public int productInsert(ProductVO prod);
	
	public List<ProductVO> productList();

	// [관리자 모드]=>배송상태, 지불상태를 관리하는 메소드
	void manageOrder(String onum, String colName, String colVal);

	// [관리자 모드]=>월별 주문 목록 가져오기
	List<OrderVO> getOrderListByMonth(String month);

	List<ProductVO> getProducts(int cg_num);

}
