package com.npu.libraryapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.npu.libraryapp.domain.Book;

public class BookRowMapper implements RowMapper<Book> {

	public Book mapRow(ResultSet resultSet, int row) throws SQLException {
		Book book = new Book();
		
		book.setBookid(resultSet.getInt("bookid"));
		book.setTitle(resultSet.getString("title"));
		book.setAuthor(resultSet.getString("author"));
		book.setIsbn(resultSet.getInt("isbn"));
		return book;
	}

}
