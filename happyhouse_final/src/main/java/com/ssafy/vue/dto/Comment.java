package com.ssafy.vue.dto;

import java.util.Date;

public class Comment {
	private int no;
	private String boardNo;
	private String writer;
	private String contents;
	
	
	
	public Comment(int no, String boardNo, String writer, String contents) {
		super();
		this.no = no;
		this.boardNo = boardNo;
		this.writer = writer;
		this.contents = contents;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "Comment [no=" + no + ", boardNo=" + boardNo + ", writer=" + writer + ", contents=" + contents + "]";
	}

	
}	