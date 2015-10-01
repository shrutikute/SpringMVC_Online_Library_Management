//package com.npu.libraryapp.dao.jdbc;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import com.npu.libraryapp.domain.LoginModel;
//
//
//public class LoginRowMapper implements RowMapper<LoginModel> {
//
//	public LoginModel mapRow(ResultSet resultSet, int row) throws SQLException {
//		LoginModel login;
//		
//		login = new LoginModel();	
//		login.setUserName(resultSet.getString("userName"));
//		login.setPassword(resultSet.getString("password"));
//		return login;
//	}
//
//}
