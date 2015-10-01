package com.npu.libraryapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.npu.libraryapp.dao.BookIssueDAO;
import com.npu.libraryapp.dao.ConnectionDAO;
import com.npu.libraryapp.domain.BookIssue;


@Repository("bookIssueDaoJdbc")
@Transactional
public class BookIssueDaoJdbcImpl implements BookIssueDAO  {
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private NamedParameterJdbcTemplate namedTemplate;
	private BookIssueRowMapper bookIssueRowMapper;
	private BookIssueMapper bookIssueMapper;
	
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcInsert = new SimpleJdbcInsert(dataSource)
							.withTableName("bookissue")
							.usingGeneratedKeyColumns("id");
		bookIssueRowMapper = new BookIssueRowMapper();
		bookIssueMapper = new BookIssueMapper();
	}


	@Transactional
	public int findMemidByBookid(int bookid) {
		String sql = "select memid from Bookissue where bookid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class , bookid );
	}
	
	
	public List<BookIssue> getMemidByBookid(int bookid) {
		String sql = "select memid from bookissue where bookid=?";
		List<BookIssue> list = jdbcTemplate.query(sql, bookIssueMapper , bookid );
		System.out.println(list);	
		return list;
	}


	@Override
	public void insertEntry(BookIssue bookIssue) {

		SqlParameterSource params = new BeanPropertySqlParameterSource(bookIssue);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		bookIssue.setId(newId.intValue());
	}


}








