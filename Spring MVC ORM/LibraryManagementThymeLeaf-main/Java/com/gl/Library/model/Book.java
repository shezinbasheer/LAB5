package com.gl.Library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;		
	
	private String title; 
	
	private String author;  
	
	private String category;
	
	public Book() {}

	public Book(int id, String title, String author, String category) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
	}  
	
	public Book(String title, String author, String category) {
		this.title = title;
		this.author = author;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}  
	

}
