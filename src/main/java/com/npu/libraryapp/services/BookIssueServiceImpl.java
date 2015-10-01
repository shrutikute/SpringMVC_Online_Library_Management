package com.npu.libraryapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npu.libraryapp.dao.BookDAO;
import com.npu.libraryapp.dao.BookIssueDAO;
import com.npu.libraryapp.dao.MemberDAO;
import com.npu.libraryapp.domain.Book;
import com.npu.libraryapp.domain.BookIssue;
import com.npu.libraryapp.domain.Member;

@Service
@Transactional
public class BookIssueServiceImpl implements BookIssueService {
	
	@Autowired
	private BookIssueDAO bookIssueDao;;
	@Autowired
	private BookDAO bookDao;
	@Autowired
	private MemberDAO memberDao;;

	
	@Transactional
	public List<Member> findMemberDetails(String title) {
		
		int bookid;
		
		List<BookIssue> memids = new ArrayList<BookIssue>() ;
		List<Member> names = new ArrayList<Member>() ;
		
		bookid = bookDao.findBookIdByName(title);
		
		System.out.println("Book Id: " +bookid);
		
		memids = bookIssueDao.getMemidByBookid(bookid);		
		
		int length = memids.size();
		for(int i = 0; i < length; i++) {
			int mem_id = memids.get(i).getMemid();
			  names.addAll(memberDao.findMemberById(mem_id));				
	        }
		System.out.println(names + "ninin");
		
		return names;	

	}
	
	@Transactional
	public void addNewEntry(BookIssue bookIssue) {
		
		try {
			bookIssueDao.insertEntry(bookIssue);
			System.out.println( "Transaction Added To The Database Successfully");
		} catch (Exception ex) {
			System.out.println("Failed because of exception: " + ex);
		}
	}

}
