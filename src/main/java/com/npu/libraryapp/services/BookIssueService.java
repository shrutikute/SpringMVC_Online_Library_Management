package com.npu.libraryapp.services;

import java.util.List;

import com.npu.libraryapp.domain.Book;
import com.npu.libraryapp.domain.BookIssue;
import com.npu.libraryapp.domain.Member;


public interface BookIssueService {
	public List<Member> findMemberDetails(String title);
	public void addNewEntry(BookIssue bookIssue);

}
