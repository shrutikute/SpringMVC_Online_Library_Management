package com.npu.libraryapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.npu.libraryapp.domain.Book;
import com.npu.libraryapp.domain.BookIssue;

public class BookIssueMapper implements RowMapper<BookIssue> {

	public BookIssue mapRow(ResultSet resultSet, int row) throws SQLException {
		BookIssue book = new BookIssue();
	
		book.setMemid(resultSet.getInt("memid"));
		return book;
	}

}
