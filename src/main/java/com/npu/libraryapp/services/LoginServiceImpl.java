//package com.npu.libraryapp.services;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.npu.libraryapp.dao.LoginDAO;
//import com.npu.libraryapp.domain.LoginModel;
//
//
//@Service("loginService")
//public class LoginServiceImpl implements LoginService {
//	@Autowired
//	LoginDAO loginDAO;
//	
//	public boolean validate(LoginModel loginModel) {
//		return loginDAO.validate(loginModel);
//	}
//
//
//	public void addNewEntry(LoginModel loginModel) {
//		
//		try {
//			loginDAO.insertEntry(loginModel);
//			System.out.println( "New Entry Added To The Database Successfully");
//		} catch (Exception ex) {
//			System.out.println("Failed because of exception: " + ex);
//		}
//	}
//
//}
