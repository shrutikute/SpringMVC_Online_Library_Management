package com.npu.libraryapp.services;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npu.libraryapp.dao.MemberDAO;
import com.npu.libraryapp.domain.Member;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;;

	@Transactional
	public void addNewMember(Member member) {

		try {
			memberDao.insertMember(member);
			System.out.println("Member Added To The Database Successfully");
		} catch (Exception ex) {
			System.out.println("Failed because of exception: " + ex);
		}
	}

	@Transactional
	public void deleteByMemberId(int id) {
		memberDao.deleteByMemberId(id);
		System.out.println("Record from Member table deleted successfully \n");
	}

	@Transactional
	public int getTotalNumberOfMembers() {
		int total = memberDao.getMemberCount();
		System.out.println("Total number of Members : " + total);
		return total;
	}

	@Transactional
	public Member findMemberDetails(String title) {
		Member member;
		member = memberDao.findMemberByName(title);

		System.out.println("Details of the Member for given name is : [ Name: "
				+ memberDao.findMemberByName(title).getName() + ", Member ID: "
				+ memberDao.findMemberByName(title).getMemid()
				+ ", Member Address: "
				+ memberDao.findMemberByName(title).getAddress()
				+ ", Member Classification: "
				+ memberDao.findMemberByName(title).getClassification() + " ]");

		return member;

	}

	@Transactional
	public String findMemberNameById(int memid) {
		String name = memberDao.findMemberNameById(memid);
		System.out.println("Name of the Member with given Id is : "
				+ memberDao.findMemberNameById(memid));
		return name;
	}

	public boolean validate(Member member) {
		return memberDao.validate(member);
	}

	public int findMemberIdByName(String name) throws SQLException,
			NamingException {

		int mem = memberDao.findMemberIdByName(name);
		
		return mem;
	}
}
