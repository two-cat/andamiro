package com.ict.domain;

import java.sql.Date;

public class ReviewVO {

	private int pnum_fk;
	private int num;
	private int idx_fk;
	private String name;
	private int score;
	private String title;
	private String content;
	private String fileName;
	private java.sql.Date wdate;
	
	public ReviewVO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPnum_fk() {
		return pnum_fk;
	}

	public void setPnum_fk(int pnum_fk) {
		this.pnum_fk = pnum_fk;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getIdx_fk() {
		return idx_fk;
	}

	public void setIdx_fk(int idx_fk) {
		this.idx_fk = idx_fk;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public java.sql.Date getWdate() {
		return wdate;
	}

	public void setWdate(java.sql.Date wdate) {
		this.wdate = wdate;
	}

	public ReviewVO(int pnum_fk, int num, int idx_fk, int score, String title, String content, String fileName,
			Date wdate) {
		super();
		this.pnum_fk = pnum_fk;
		this.num = num;
		this.idx_fk = idx_fk;
		this.score = score;
		this.title = title;
		this.content = content;
		this.fileName = fileName;
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "ReviewVO [pnum_fk=" + pnum_fk + ", num=" + num + ", idx_fk=" + idx_fk + ", score=" + score + ", title="
				+ title + ", content=" + content + ", fileName=" + fileName + ", wdate=" + wdate + "]";
	}

		
}
