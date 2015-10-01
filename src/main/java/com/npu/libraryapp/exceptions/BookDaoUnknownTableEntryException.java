package com.npu.libraryapp.exceptions;

public class BookDaoUnknownTableEntryException extends Exception {
	public BookDaoUnknownTableEntryException(String msg) {
		super(msg);
}
}