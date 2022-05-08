package com.ict.domain;

import java.sql.Date;

public class ProductVO {
	private int cg_num_fk;
	private String cg_name;
	
	private int pnum;
	private String pname;
	private String pimage1;
	private String pimage2;
	private String pimage3;
	
	private int price;
	private int saleprice;
	private int point;
	private int pqty;
	
	private String pspec;
	private String pcontents;
	private String pcompany;
	private Date pindate;
	
	private int totalPrice; /*�� �ǸŰ� = ��ǰ �ǸŰ� x ����*/
	private int totalPoint; /*�� ����Ʈ = ����Ʈ x ����*/
	
	private String onum; //��ǰ �ֹ��� ����� �ֹ���ȣ
	
	public ProductVO() {
		
	}
	//setter, getter -------
	public int getCg_num_fk() {
		return cg_num_fk;
	}
	
	public void setCg_num_fk(int cg_num_fk) {
		this.cg_num_fk = cg_num_fk;
	}

	public String getCg_name() {
		return cg_name;
	}

	public void setCg_name(String cg_name) {
		this.cg_name = cg_name;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
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

	public String getPimage2() {
		return pimage2;
	}

	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}

	public String getPimage3() {
		return pimage3;
	}

	public void setPimage3(String pimage3) {
		this.pimage3 = pimage3;
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

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
		//////////////�� �ǸŰ��� �� ����Ʈ�� ��������/////////////////
		this.totalPrice=this.saleprice * this.pqty;
		this.totalPoint=this.point * this.pqty;
		///////////////////////////////////////////////////
	}

	public String getPspec() {
		return pspec;
	}

	public void setPspec(String pspec) {
		this.pspec = pspec;
	}

	public String getPcontents() {
		return pcontents;
	}

	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}

	public String getPcompany() {
		return pcompany;
	}

	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}

	public Date getPindate() {
		return pindate;
	}

	public void setPindate(Date pindate) {
		this.pindate = pindate;
	}

	public String getOnum() {
		return onum;
	}

	public void setOnum(String onum) {
		this.onum = onum;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public int getTotalPoint() {
		return totalPoint;
	}
	/**���η��� ��ȯ�ϴ� �޼ҵ�*/
	public int getPercent() {
		// (���� - �ǸŰ�)*100/����
		int percent = (this.price - this.saleprice)*100/this.price;
		return percent;
	}

	@Override
	public String toString() {
		return "ProductVO [cg_num_fk=" + cg_num_fk + ", cg_name=" + cg_name + ", pnum=" + pnum + ", pname=" + pname
				+ ", pimage1=" + pimage1 + ", pimage2=" + pimage2 + ", pimage3=" + pimage3 + ", price=" + price
				+ ", saleprice=" + saleprice + ", point=" + point + ", pqty=" + pqty + ", pspec=" + pspec
				+ ", pcontents=" + pcontents + ", pcompany=" + pcompany + ", pindate=" + pindate + ", totalPrice="
				+ totalPrice + ", totalPoint=" + totalPoint + ", onum=" + onum + "]";
	}
}
