package com.gl.Library.service;

import java.util.List;

import com.gl.Library.model.Book;

public interface LibraryService {

	Book addBook(Book b2);
	Book getBook(int id);
	List<Book> getAllBooks();
	void deleteBook(int id);
	Book updateBook(int bid, Book b3);
	List<Book> getBookByAuthorName(String aname);
	List<Book> getBookByCategory(String category);
}
