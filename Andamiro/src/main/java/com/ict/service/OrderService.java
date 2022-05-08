package com.ict.service;

import java.util.List;

import com.ict.domain.OrderVO;

public interface OrderService {
	// �ֹ����� ������ �ֹ���ǰ����, ������ ������ insert�ϴ� �޼ҵ�
	// �ֹ����� ���ϸ��� �������� ���� �Ǵ� ���� ó��
	String orderInsert(OrderVO ovo);

	// �ֹ���ȣ�� �ֹ� ���������� �������� �޼ҵ�
	List<OrderVO> getOrderDesc(String onum);

	// ȸ����ȣ�� ȸ���� �ֹ��� ����� �������� �޼ҵ�
	List<OrderVO> getUserOrderList(int idx_fk);

}