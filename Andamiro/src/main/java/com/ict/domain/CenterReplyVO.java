package com.ict.domain;

import java.sql.Date;

public class CenterReplyVO {
	private int cr_idx;
	private String cr_content;
	private Date cr_date;
	private String name;
	private int sc_idx_fk;

	public int getCr_idx() {
		return cr_idx;
	}

	public void setCr_idx(int cr_idx) {
		this.cr_idx = cr_idx;
	}

	public String getCr_content() {
		return cr_content;
	}

	public void setCr_content(String cr_content) {
		this.cr_content = cr_content;
	}

	public Date getCr_date() {
		return cr_date;
	}

	public void setCr_date(Date cr_date) {
		this.cr_date = cr_date;
	}

	public int getSc_idx_fk() {
		return sc_idx_fk;
	}

	public void setSc_idx_fk(int sc_idx_fk) {
		this.sc_idx_fk = sc_idx_fk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CenterReplyVO [cr_idx=" + cr_idx + ", cr_content=" + cr_content + ", cr_date=" + cr_date + ", name="
				+ name + ", sc_idx_fk=" + sc_idx_fk + "]";
	}

	

}
