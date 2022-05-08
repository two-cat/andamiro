package com.ict.domain;

import java.sql.Date;

public class CartVO {
	private int cartNum;
	private int oqty; // ����
	private Date indate;
	private int idx_fk; // ȸ����ȣ
	private int pnum_fk; // ��ǰ��ȣ

	// ��ٱ��� ��ǰ ����--
	private String pname;// ��ǰ��
	private String pimage1;
	private int price;
	private int saleprice;
	private int point;

	private int totalPrice;// �ǸŰ�*���� => �ݾ�
	private int totalPoint;

	// ��ٱ��� �Ѿװ� ������Ʈ
	private int cartTotalPrice;// ��ٱ��Ͽ� ��� ��� ��ǰ�� �Ѿ�
	private int cartTotalPoint;

	public int getCartNum() {
		return cartNum;
	}

	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}

	public int getOqty() {
		return oqty;
	}

	public void setOqty(int oqty) {
		this.oqty = oqty;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public int getIdx_fk() {
		return idx_fk;
	}

	public void setIdx_fk(int idx_fk) {
		this.idx_fk = idx_fk;
	}

	public int getPnum_fk() {
		return pnum_fk;
	}

	public void setPnum_fk(int pnum_fk) {
		this.pnum_fk = pnum_fk;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPimage1() {
		return pimage1;
	}

	public void setPimage1(String pimage1) {
		this.pimage1 = pimage1;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public int getCartTotalPrice() {
		return cartTotalPrice;
	}

	public void setCartTotalPrice(int cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}

	public int getCartTotalPoint() {
		return cartTotalPoint;
	}

	public void setCartTotalPoint(int cartTotalPoint) {
		this.cartTotalPoint = cartTotalPoint;
	}

	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", oqty=" + oqty + ", indate=" + indate + ", idx_fk=" + idx_fk
				+ ", pnum_fk=" + pnum_fk + ", pname=" + pname + ", pimage1=" + pimage1 + ", price=" + price
				+ ", saleprice=" + saleprice + ", point=" + point + ", totalPrice=" + totalPrice + ", totalPoint="
				+ totalPoint + ", cartTotalPrice=" + cartTotalPrice + ", cartTotalPoint=" + cartTotalPoint + "]";
	}

	
}
