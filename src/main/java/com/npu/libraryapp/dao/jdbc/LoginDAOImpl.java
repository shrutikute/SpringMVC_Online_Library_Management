//package com.npu.libraryapp.dao.jdbc;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.annotation.PostConstruct;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.mysql.jdbc.PreparedStatement;
//import com.npu.libraryapp.dao.ConnectionDAO;
//import com.npu.libraryapp.dao.LoginDAO;
//import com.npu.libraryapp.domain.LoginModel;
//
//
//@Repository("loginDAO")
//@Transactional
//public class LoginDAOImpl implements LoginDAO {
//
//	@Autowired
//	@Qualifier("dataSource")
//	private DataSource dataSource;
//	private JdbcTemplate jdbcTemplate;
//	private SimpleJdbcInsert jdbcInsert;
//	private NamedParameterJdbcTemplate namedTemplate;
//	
//	@PostConstruct
//	public void setup() {
//		jdbcTemplate = new JdbcTemplate(dataSource);
//		namedTemplate = new NamedParameterJdbcTemplate(dataSource);
//		jdbcInsert = new SimpleJdbcInsert(dataSource)
//		.withTableName("loginModel").usingGeneratedKeyColumns("id");
//		
//	}
//	
//	@Override
//	public boolean validate(LoginModel loginModel)
//	{
//		String SQL = "select * from loginModel where username = '"+loginModel.getUserName()+"' and password = '"+loginModel.getPassword()+"';";
//		System.out.println("SQL : "+ SQL);
//		Statement stmt;
//		try
//		{
//			stmt = ConnectionDAO.getStatement();
//			ResultSet rs = stmt.executeQuery(SQL);
//			if (null!= rs && rs.next())
//			{
//				return true;
//			}
//			else
//			{
//				return false;
//			}
//		}
//		catch (SQLException e)
//		{
//			System.out.println("SQL Exception : "+e.getMessage());
//			return false;
//		}
//	}
//
//	
//	public void insertEntry(LoginModel loginModel) {
//		int id;
//		SqlParameterSource params = new BeanPropertySqlParameterSource(loginModel);
//		Number newId = jdbcInsert.executeAndReturnKey(params);
//		id = newId.intValue();
//		loginModel.setId(id);
//		
//		
//
//	}
//
//	
//}
