package com.gl.Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.Library.model.Book;
import com.gl.Library.repository.BookRepository;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	BookRepository bookRepository;
	

	public Book addBook(Book b2) {
		return bookRepository.save(b2);	
	}


	public Book getBook(int id) {
		return bookRepository.findById(id).get();
		
	}


	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}


	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}


	public Book updateBook(int bid, Book b3) {
		Book bookdb=getBook(bid);
		bookdb.setAuthor(b3.getAuthor());
		bookdb.setTitle(b3.getTitle());
		bookdb.setCategory(b3.getCategory());
		return bookRepository.save(bookdb);
	}


	@Override
	public List<Book> getBookByAuthorName(String aname) {
		return bookRepository.getBookByAuthorName(aname);
	}


	@Override
	public List<Book> getBookByCategory(String category) {
		return bookRepository.findByCategory(category);
	}

	
}
