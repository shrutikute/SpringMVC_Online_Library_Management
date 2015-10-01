package com.npu.libraryapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npu.libraryapp.dao.BookDAO;
import com.npu.libraryapp.domain.Book;


@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDao;

	@Transactional
	public void addNewBook(Book book) {
	
		try {
			bookDao.insertBook(book);
			System.out.println( "\nBook Added To The Database Successfully");
		} catch (Exception ex) {
			System.out.println("Failed because of exception: " + ex);
		}
	}

	@Transactional
	public void deleteBook(String title){
		bookDao.deleteByBookTitle(title);
		System.out.println("Record from Book table deleted successfully ");

	}
	
	@Transactional
	public int getTotalNumberOfBooks(){
		int total = bookDao.getBookCount();
		System.out.println("Total number of books : " + total);
		return total;
	}

	
	@Transactional
	public Book findBookDetails(String title) {
		Book book;
		book = bookDao.findBookByName(title);

		System.out.println("Details of the book for given name is : [ Title: "
				+ bookDao.findBookByName(title).getTitle() + ", Book ID: "
				+ bookDao.findBookByName(title).getBookid() + ", Author: "
				+ bookDao.findBookByName(title).getAuthor() + ", ISBN: "
				+ bookDao.findBookByName(title).getIsbn() + " ]");
		
		return book;	

	}

	@Transactional
	public String findBookNameById(int bookid) {
		String name = bookDao.findBookNameById(bookid);
		System.out.println("Title of the book with ID given is : " + bookDao.findBookNameById(bookid));
		return name;
	}

	@Transactional
	public void updateRecord(Book book, int change) {
		bookDao.updateIsbn(book, change);
		System.out.println("ISBN Record updated successfully ");
		 
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<Book>();
		list = bookDao.findAllBooks();
		return list;
	}




}
