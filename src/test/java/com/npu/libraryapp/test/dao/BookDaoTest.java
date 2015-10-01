package com.npu.libraryapp.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.npu.libraryapp.dao.BookDAO;
import com.npu.libraryapp.domain.Book;
import com.npu.libraryapp.exceptions.BookDaoCheckedException;
	
	@ContextConfiguration("classpath:bookdao-test-context.xml")
	@RunWith(SpringJUnit4ClassRunner.class)
	public class BookDaoTest {
		@Autowired
		@Qualifier("bookDaoJdbc")
		private BookDAO bookDAO;

		@Test
		public void testBookCount() throws BookDaoCheckedException {
			int origBookCnt, newBookCnt;
	
			
			Book book = new Book();
			book.setTitle("INTERNET");
			book.setAuthor("JOHNSON");
			book.setIsbn(5555);
			
			origBookCnt = bookDAO.getBookCount();
			
			bookDAO.insertBook(book);
			
			newBookCnt = bookDAO.getBookCount();
			
			assertTrue((origBookCnt+1) == newBookCnt); 
		}
		
		@Test
		public void testFindProdNameById() {
			String name = bookDAO.findBookNameById(202);
			assertEquals(name,"SCIENCE");
	}
	
	}
