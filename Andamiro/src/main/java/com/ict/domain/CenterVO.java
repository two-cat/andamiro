package com.ict.domain;

import java.sql.Date;

public class CenterVO {
	private int sc_idx;
	private String sc_title;
	private String sc_content;
	private Date sc_date;

	private int idx_fk;
	private String name;

	// getter setter~~~~~
	public int getSc_idx() {
		return sc_idx;
	}

	public void setSc_idx(int sc_idx) {
		this.sc_idx = sc_idx;
	}

	public String getSc_title() {
		return sc_title;
	}

	public void setSc_title(String sc_title) {
		this.sc_title = sc_title;
	}

	public String getSc_content() {
		return sc_content;
	}

	public void setSc_content(String sc_content) {
		this.sc_content = sc_content;
	}

	public Date getSc_date() {
		return sc_date;
	}

	public void setSc_date(Date sc_date) {
		this.sc_date = sc_date;
	}

	public int getIdx_fk() {
		return idx_fk;
	}

	public void setIdx_fk(int idx_fk) {
		this.idx_fk = idx_fk;
	}

	public String getName() {
		System.out.println("getName : " + name);
		return name;
	}

	public void setName(String name) {
		System.out.println("name : " + name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "CenterVO [sc_idx=" + sc_idx + ", sc_title=" + sc_title + ", sc_content=" + sc_content + ", sc_date="
				+ sc_date + ", sc_fileName="  + ", idx_fk=" + idx_fk + ", name=" + name + "]";
	}

}
