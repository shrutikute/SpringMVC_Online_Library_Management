package com.npu.libraryapp.domain;


import java.util.Date;

public class BookIssue {
	private int id;
	private int memid;
	private int bookid;
	private Date date;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMemid() {
		return memid;
	}
	public void setMemid(int memid) {
		this.memid = memid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString() {
		
		String bookissueStr = (" Information (id: " + id + " date: " + date + " memberID: " + memid + " bookID: " + bookid +")");
		return bookissueStr;
	}

}





