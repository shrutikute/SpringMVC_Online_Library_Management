package com.npu.libraryapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.npu.libraryapp.domain.Member;


public class MemberIdNameRowMapper implements RowMapper<Member> {

	public Member mapRow(ResultSet resultSet, int row) throws SQLException {
		Member member;
		
		member = new Member();	
		member.setMemid(resultSet.getInt("memid"));
		member.setName(resultSet.getString("name"));
	
		return member;
	}

}
