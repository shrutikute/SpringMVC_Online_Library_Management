package com.npu.libraryapp.dao;

import java.util.List;

import com.npu.libraryapp.domain.Book;
import com.npu.libraryapp.exceptions.BookDaoCheckedException;
import com.npu.libraryapp.exceptions.BookNotFoundException;


public interface BookDAO {
	public int getBookCount();
	public String findBookNameById(int id);
	public Book findBookByName(String bookTitle);
	public void insertBook(Book book) throws BookDaoCheckedException;
	public int updateIsbn(Book book, int change);
	public int deleteByBookTitle(String title);
	public int updateTotalRecord(String bookName, int change) throws BookNotFoundException;
	public int findBookIdByName(String title);
	public List<Book> findAllBooks();
	//	public int updateIsbn(Book book, int change);

}

