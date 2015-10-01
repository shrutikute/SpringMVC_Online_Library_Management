package com.npu.libraryapp.dao.jdbc;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.npu.libraryapp.dao.BookDAO;
import com.npu.libraryapp.domain.Book;
import com.npu.libraryapp.exceptions.BookDaoCheckedException;
import com.npu.libraryapp.exceptions.BookDaoException;
import com.npu.libraryapp.exceptions.BookDaoRuntimeException;
import com.npu.libraryapp.exceptions.BookNotFoundException;


@Repository("bookDaoJdbc")
@Transactional
public class BookDaoJdbcImpl implements BookDAO  {
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private NamedParameterJdbcTemplate namedTemplate;
	private BookRowMapper bookRowMapper;
	
	
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcInsert = new SimpleJdbcInsert(dataSource)
							.withTableName("book")
							.usingGeneratedKeyColumns("id");
		bookRowMapper = new BookRowMapper();
	}

	public int getBookCount() {
		String sql = "select count(*) from Book";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public void insertBook(Book book) throws BookDaoCheckedException {
		if (book == null) {
			throw new BookDaoRuntimeException("Attempting to insert null product");
		}
		
		if (book.getIsbn() <= 0) {
			throw new BookDaoCheckedException("Attempting to insert a product with invalid isbn");
		}
		
		SqlParameterSource params = new BeanPropertySqlParameterSource(book);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		book.setBookid(newId.intValue());
	}

	public String findBookNameById(int bookid) {
		String sql = "select title from Book where bookid=?";
		return jdbcTemplate.queryForObject(sql, String.class, bookid);	

	}

	public Book findBookByName(String title) {
		int bookFound;
		
		String sql = "select * from Book where title=?";
		
		List<Book> bookList = jdbcTemplate.query(sql, bookRowMapper, title );
		
		bookFound = bookList.size();
		if (bookFound == 1) {
			return bookList.get(0);
		} else if (bookFound == 0) {
			return null;
		}
		throw new BookDaoException("Multiple Book Found with Same Name");
	
	}
	
	public int findIsbnByName(String title) {
		String sql = "select isbn from Book where title=?";
		return jdbcTemplate.queryForObject(sql, Integer.class , title );	
	}

	
	public int deleteByBookTitle(String title) {
		String sql = "DELETE from book where title = ? " ;
		int rowsRemoved = jdbcTemplate.update(sql, title);
		return rowsRemoved;
		
	}	
	
//	public int updateIsbn(int oldIsbn, int newIsbn){
//		String sql = "UPDATE book set isbn = ? where isbn = ? " ;
//		int rowsChanged = jdbcTemplate.update(sql, newIsbn, oldIsbn);
//		return rowsChanged;
//		
//	}
	
	public int updateIsbn(Book book, int change) {
		String sql = "update book set isbn=:newIsbn where bookid=:id";
		int curIsbn, newIsbn;
		String bookName;
		MapSqlParameterSource params;
		int rowsAffected;
		int bookId = book.getBookid();
		
		bookName = book.getTitle();
		curIsbn = findIsbnByName(bookName);
		
		newIsbn = curIsbn + change;
		
		params = new MapSqlParameterSource("id", bookId);
		params.addValue("newIsbn", newIsbn);
		rowsAffected = namedTemplate.update(sql, params);
		return rowsAffected;
	}
	
	public int updateTotalRecord(String bookName, int change) throws BookNotFoundException {
		String sql = "update book set isbn=:newTotalOrders where bookid=:id";
		int curIsbn, newIsbn;
		Book book;
		MapSqlParameterSource params;
		int bookId, rowsAffected;
		
		book = findBookByName(bookName);
		if (book == null) {
			throw new BookNotFoundException(bookName);
		}
		
		curIsbn = book.getIsbn();
		newIsbn = curIsbn + change;
		bookId = book.getBookid();
		
		params = new MapSqlParameterSource("id", bookId);
		params.addValue("newTotalOrders", newIsbn);
		rowsAffected = namedTemplate.update(sql, params);
		return rowsAffected;
	}

	@Transactional
	public int findBookIdByName(String title) {
			String sql = "select bookid from Book where title=?";	
			return jdbcTemplate.queryForObject(sql, Integer.class , title );	
		}
	
	public List<Book> findAllBooks() {
	    return this.jdbcTemplate.query( "select title, bookid from book", new BookMapper());
	}

}


	
	



