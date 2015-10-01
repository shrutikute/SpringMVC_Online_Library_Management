package com.npu.libraryapp.services;

import java.util.List;

import com.npu.libraryapp.domain.Book;


public interface BookService {
	public void addNewBook(Book book);
	public void deleteBook(String title);
	public int getTotalNumberOfBooks();
	public Book findBookDetails(String title);
	public String findBookNameById(int bookid);
	public void updateRecord(Book book, int change);
	public List<Book> getAllBooks();
}
