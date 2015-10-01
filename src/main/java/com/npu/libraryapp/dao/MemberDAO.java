package com.npu.libraryapp.dao;


import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.npu.libraryapp.domain.BookIssue;
import com.npu.libraryapp.domain.Member;


public interface MemberDAO {

	public int getMemberCount();
	public String findMemberNameById(int id);
	public Member findMemberByName(String name);
	public void insertMember(Member member);
	public int deleteByMemberId(int id);
	public  List<Member> findMemberById(int memid);
	public int findMemberIdByName(String username) throws SQLException, NamingException;
	public boolean validate(Member member);
	
	public List<Member> findAllMembers(int id);
	//public void insertEntry(Member member);
	

}
