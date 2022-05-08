package com.ict.domain;

import java.sql.Date;
import java.util.List;

public class OrderVO {
	// orderDesc ���� ������Ƽ
	private String onum; // �ֹ���ȣ
	private int idx_fk; // �ֹ��� ȸ����ȣ
	private int ototalPrice; // �ֹ��Ѿ�
	private int ototalPoint;
	private int odeliverCost; // ��ۺ�(default 3000)
	private String odeliverState;// ��ۻ���(�����, �����, ��ۿϷ�)
	private String opayWay;// ���ҹ��(100:�������Ա�, 200:ī�����)
	private String opayState;// ���һ���(�̰���,�����Ϸ�,�������)
	private Date orderDate;// �ֹ���
	private int omileage;// ��� ���ϸ���
	private String omemo;// �ֹ� ��û����

	private String pname;
	private String pimage;
	// orderProduct���� ������Ƽ
	// OrderVO has Products
	private List<ProductVO> orderList;// �ֹ���ǰ ���

	// OrderVO has a Receiver
	private ReceiverVO receiver;// ������ ����

	// setter, getter-------
	public String getOnum() {
		return onum;
	}

	public void setOnum(String onum) {
		this.onum = onum;
	}

	public int getIdx_fk() {
		return idx_fk;
	}

	public void setIdx_fk(int idx_fk) {
		this.idx_fk = idx_fk;
	}

	public int getOtotalPrice() {
		return ototalPrice;
	}

	public void setOtotalPrice(int ototalPrice) {
		this.ototalPrice = ototalPrice;
	}

	public int getOtotalPoint() {
		return ototalPoint;
	}

	public void setOtotalPoint(int ototalPoint) {
		this.ototalPoint = ototalPoint;
	}

	public int getOdeliverCost() {
		return odeliverCost;
	}

	public void setOdeliverCost(int odeliverCost) {
		this.odeliverCost = odeliverCost;
	}

	public String getOdeliverState() {
		return odeliverState;
	}

	public void setOdeliverState(String odeliverState) {
		this.odeliverState = odeliverState;
	}

	public String getOpayWay() {
		return opayWay;
	}

	public void setOpayWay(String opayWay) {
		this.opayWay = opayWay;
	}

	public String getOpayState() {
		return opayState;
	}

	public void setOpayState(String opayState) {
		this.opayState = opayState;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOmileage() {
		return omileage;
	}

	public void setOmileage(int omileage) {
		this.omileage = omileage;
	}

	public String getOmemo() {
		return omemo;
	}

	public void setOmemo(String omemo) {
		this.omemo = omemo;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public List<ProductVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ProductVO> orderList) {
		this.orderList = orderList;
	}

	public ReceiverVO getReceiver() {
		return receiver;
	}

	public void setReceiver(ReceiverVO receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "OrderVO [onum=" + onum + ", idx_fk=" + idx_fk + ", ototalPrice=" + ototalPrice + ", ototalPoint="
				+ ototalPoint + ", odeliverCost=" + odeliverCost + ", odeliverState=" + odeliverState + ", opayWay="
				+ opayWay + ", opayState=" + opayState + ", orderDate=" + orderDate + ", omileage=" + omileage
				+ ", omemo=" + omemo + ", pname=" + pname + ", pimage=" + pimage + ", orderList=" + orderList
				+ ", receiver=" + receiver + "]";
	}
	
}
