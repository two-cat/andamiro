package com.ict.mapper;

import java.util.List;

import com.ict.domain.OrderVO;
import com.ict.domain.ProductVO;

public interface OrderMapper {
	// �ֹ� ���������� insert�ϴ� �޼ҵ�
	int orderDescInsert(OrderVO ovo);

	// �ֹ� ��ǰ���� insert
	int orderProductInsert(ProductVO prod);

	// ������ ���� insert
	int receiverInsert(OrderVO ovo);

	List<OrderVO> getOrderDesc(String onum);

	List<OrderVO> getUserOrderList(int midx_fk);
}
