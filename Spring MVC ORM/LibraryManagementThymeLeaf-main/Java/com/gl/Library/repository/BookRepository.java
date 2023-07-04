package com.gl.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.Library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query(value="select * from book where author like ?1",nativeQuery=true)
	public List<Book> getBookByAuthorName(String aname);
	
	public List<Book> findByCategory(String cname);
	

}



