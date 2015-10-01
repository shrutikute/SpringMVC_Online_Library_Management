package com.npu.libraryapp.services;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.npu.libraryapp.domain.Member;



public interface MemberService {
	public void addNewMember(Member member);
	public void deleteByMemberId(int memid);
	public int getTotalNumberOfMembers();
	public Member findMemberDetails(String name);
	public String findMemberNameById(int memid);
	public int findMemberIdByName(String name) throws SQLException,
	NamingException;
	public boolean validate(Member loginModel);
	//public void addNewEntry(Member loginModel);
}
