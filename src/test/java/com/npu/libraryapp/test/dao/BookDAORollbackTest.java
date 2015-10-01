package com.npu.libraryapp.test.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.npu.libraryapp.dao.BookDAO;
import com.npu.libraryapp.domain.Book;
import com.npu.libraryapp.exceptions.BookDaoCheckedException;
import com.npu.libraryapp.exceptions.BookDaoRuntimeException;

@ContextConfiguration("classpath:bookdao-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookDAORollbackTest {
	@Autowired
	@Qualifier("bookDaoJdbc")
	private BookDAO BookDAO;
	private Book goodBook;
	private Logger bookLogger =  Logger.getLogger(BookDAORollbackTest.class);

	@Before
	public void init() {
		/*   A Book that should not be in our database -- to help us test error scenarios */
		
		goodBook = new Book();
		goodBook.setTitle("GZeee");
		goodBook.setAuthor("ABC");
		goodBook.setIsbn(10);
	}
	
	/* This test will demonstrate handling of an UNCHECKED exception */

	@Test /* Exception should be thrown by the BookDao.  Make sure the Book insert was rolled back */
	public void testNullBookInsert() throws BookDaoCheckedException {
		int origBookCnt, newBookCnt;
		
		goodBook = new Book();
		goodBook.setTitle("KR400");
		goodBook.setAuthor("ABC");
		goodBook.setIsbn(263);
		
		origBookCnt = BookDAO.getBookCount();
		
		try {
			BookDAO.insertBook(null);
			bookLogger.info("Unexpected successful insertion");
			fail();
		} catch (BookDaoRuntimeException ex) {
			
			// At this point, the database update should have been rolled back.  
            // Catch the exception here so we can verify below that the record has not changed
			// (in other words, the database changes were correctly rolled back)
			
			bookLogger.info("Book Insert Failed. The exception is: " + ex);
		}
		
		/*  No Books should have been inserted.   If the second insert throws
		 * an exception, the entire transaction should be rolled back.
		 */
		
		newBookCnt = BookDAO.getBookCount();
		assertTrue(origBookCnt == newBookCnt);  /* if no change, then the changes were rolled back */
	}
	
	
	/* This test will demonstrate handling of a CHECKED exception */
	/* Exception should be thrown by the BookDao.  The BookDaoCheckedException will NOT be rolled
    	back by default (because it is a checked exception) -- you'll have to add the rollbackFor attribute 
    	to the @Transactional notation to get rollback 
    */
	@Test  
	public void testBadIsbnBookInsert() {
		int origBookCnt, newBookCnt;
		Book badBook;
		
		badBook = new Book();
		badBook.setTitle("Bad");
		badBook.setAuthor("ABC");
		badBook.setIsbn(0);
		
		origBookCnt = BookDAO.getBookCount();
		
		try{
			
		BookDAO.insertBook(badBook);
		bookLogger.info("Unexpected successful insertion");
		fail();
		}catch (BookDaoCheckedException ex) {
			
			bookLogger.info("book Insert Failed   The exception is: " + ex);

		}
		
		/*  No Books should have been inserted.   If the second insert throws
		 * an exception, the entire transaction should be rolled back.
		 */
		newBookCnt = BookDAO.getBookCount();
		assertTrue(origBookCnt == newBookCnt);  /* No changes were rolled back */
	}

}
