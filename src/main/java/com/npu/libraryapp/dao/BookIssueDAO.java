package com.npu.libraryapp.dao;

import java.util.List;

import com.npu.libraryapp.domain.BookIssue;

public interface BookIssueDAO {

		public int findMemidByBookid(int bookid);
		public List<BookIssue> getMemidByBookid(int bookid);
		public void insertEntry(BookIssue bookIssue);
		
	}

