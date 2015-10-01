package com.npu.libraryapp.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionDAO
{
	static Connection conn;

	public static Connection getConnection()
	{
		try
		{
			String url = "jdbc:mysql://localhost/";// e.g. jdbc:mysql://localhost:3306/
			String dbName ="cs548_library"; // here the name of Database.
			String uname = "librarydb_user"; //username
			String pwd = "spring"; //password
			
			//MySQL jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			try
			{
				if(null==conn){
					conn = DriverManager.getConnection(url+dbName,uname,pwd);
				}
			}
			catch (SQLException ex)
			{
				System.out.println("SQL Exception occurred while getting connection object. \nDetails : "+ ex.getMessage());
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Exception occurred while getting connection object. \nDetails : "+ e.getMessage());
		}
		return conn;
	}
	
	
	public static Statement getStatement()
	{
		Statement stmt = null;
		try
		{
			Connection connection = ConnectionDAO.getConnection();
			stmt=connection.createStatement();
		}
		catch (SQLException e) {
			System.out.println("Exception occurred while getting Statement object. \nDetails : "+ e.getMessage());
		}
		return stmt;
	}


}
