package com.ict.service;

import java.util.List;

import com.ict.domain.CategoryVO;
import com.ict.domain.OrderVO;
import com.ict.domain.ProductVO;


public interface AdminService {

	/** ī�װ� ��� �������� */
	List<CategoryVO> getCategoryList();
	
	public int categoryAdd(CategoryVO cvo);
	
	public int categoryDelete(int cg_num);

	/** [������ ���]- ��ǰ ���� ����ϱ� */
	public int productInsert(ProductVO prod);
	
	public List<ProductVO> productList();

	// [������ ���]=>��ۻ���, ���һ��¸� �����ϴ� �޼ҵ�
	void manageOrder(String onum, String colName, String colVal);

	// [������ ���]=>���� �ֹ� ��� ��������
	List<OrderVO> getOrderListByMonth(String month);

	List<ProductVO> getProducts(int cg_num);

}
