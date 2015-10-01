package com.npu.libraryapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.npu.libraryapp.domain.Book;

public class BookMapper implements RowMapper<Book> {

	public Book mapRow(ResultSet resultSet, int row) throws SQLException {
		Book book = new Book();
	
		book.setTitle(resultSet.getString("title"));
		book.setBookid(resultSet.getInt("bookid"));
		return book;
	}

}
