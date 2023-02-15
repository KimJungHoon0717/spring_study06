package com.JungHoon.home.dto;

import java.sql.Timestamp;

public class BDto {
	private int bid; //게시판 번호 (기본키), sequence(mvc_board_seq사용)
	private String bname;//게시판 글쓰기
	private	String btitle;//게시판 글 제목
	private	String bcontent;// 게시판 글 내용
	private	Timestamp bdate;// 게시판 글 등록 년월일시간(자동등록)
	private	int	bhit;// 글 조회수
	private	int bgroup;// 댓글 그룹 이름 (원글의 게시판 글번호)
	private	int bstep; // 댓글 단계(댓글 계층 위치
	private	int bindent; // 댓글별 들여쓰기 횟수
	public BDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BDto(int bid, String bname, String btitle, String bcontent, Timestamp bdate, int bhit, int bgruop, int step,
			int bindent) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;
		this.bgroup = bgruop;
		this.bstep = step;
		this.bindent = bindent;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public Timestamp getBdate() {
		return bdate;
	}
	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public int getBgruop() {
		return bgroup;
	}
	public void setBgruop(int bgruop) {
		this.bgroup = bgruop;
	}
	public int getStep() {
		return bstep;
	}
	public void setStep(int step) {
		this.bstep = step;
	}
	public int getBindent() {
		return bindent;
	}
	public void setBindent(int bindent) {
		this.bindent = bindent;
	}
	
}
