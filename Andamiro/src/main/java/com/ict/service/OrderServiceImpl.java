package com.ict.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ict.domain.OrderVO;
import com.ict.domain.ProductVO;
import com.ict.mapper.OrderMapper;
//import com.ict.mapper.UserMapper;
@Service
public class OrderServiceImpl implements OrderService {

	@Inject
	private OrderMapper orderMapper;
	
	/*
	 * @Inject private UserMapper userMapper;
	 */
	
	@Override
	public String orderInsert(OrderVO ovo) {
		// 1. �ֹ���ȣ ����(���ĺ��빮��3�� + ����Ͻú���)
		String onum=makeOnum();
		ovo.setOnum(onum);
		
		//2. �ֹ��������� insert => orderDesc ���̺�
		int n1=orderMapper.orderDescInsert(ovo);
		System.out.println("n1="+n1);
		
		//3. �ֹ���ǰ���� insert => 1 or ������ => orderProduct
		List<ProductVO> orderList = ovo.getOrderList();
		if(orderList!=null) {
			for(ProductVO prod:orderList) {
				prod.setOnum(onum);
				int n2=this.orderMapper.orderProductInsert(prod);
				System.out.println("n2="+n2);
			}
		}
		
		//4. ������ ���� insert => receiver���̺�
		int n3=this.orderMapper.receiverInsert(ovo);
		System.out.println("n3="+n3);
		
		/*
		 * //5. ��븶�ϸ���(omileage)�� ������ ȸ�� ���ϸ����� ������ ����ó�� if(ovo.getOmileage()>0) {
		 * userMapper.updateMileageDown(ovo); }
		 * 
		 * //6. ��������� ī�� ������� => ȸ���� ���ϸ���(mileage) ������ ��������Ʈ(ototalPoint)�� ����
		 * if(ovo.getOpayWay().equals("200")) { userMapper.updateMileageUp(ovo); }
		 */
		
		return onum;
	}

	private String makeOnum() {
		char ch1=(char)(Math.random()*26+'A');
		char ch2=(char)(Math.random()*26+'A');
		char ch3=(char)(Math.random()*26+'A');
		
		Date d = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		String time = sdf.format(d);
		
		String onum=String.valueOf(ch1)+ch2+ch3+time; //RQU202202091143
		//char+char => int promotion
		System.out.println(ch1+"/"+onum);
		
		return onum;
	}

	@Override
	public List<OrderVO> getOrderDesc(String onum) {
		return orderMapper.getOrderDesc(onum);
	}

	@Override
	public List<OrderVO> getUserOrderList(int idx_fk) {
		return orderMapper.getUserOrderList(idx_fk);
	}

}
