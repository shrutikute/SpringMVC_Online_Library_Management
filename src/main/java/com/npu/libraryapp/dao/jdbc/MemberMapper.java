package com.npu.libraryapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.npu.libraryapp.domain.Book;
import com.npu.libraryapp.domain.Member;

public class MemberMapper implements RowMapper<Member> {

	public Member mapRow(ResultSet resultSet, int row) throws SQLException {
		Member member = new Member();
	
		member.setName(resultSet.getString("name"));

		return member;
	}

}
