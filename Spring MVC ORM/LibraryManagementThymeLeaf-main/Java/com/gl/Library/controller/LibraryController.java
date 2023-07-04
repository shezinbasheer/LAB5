package com.gl.Library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.Library.model.Book;
import com.gl.Library.service.LibraryService;

@Controller
@RequestMapping("/books")
public class LibraryController {
	
	@Autowired
	LibraryService libraryService;
	
	@GetMapping("/greet")
	public String greet()
	{
		return "Hello World";
	}
	
	
	
	
	
	@GetMapping("/demo")
	public Book test()
	{
		Book b1=new Book(101,"RDPD","Alice","motivational");
		return b1;
	}
	
	@PostMapping("/addBook")
	public Book addBook(@RequestParam("id") int id, 
			 	   @RequestParam("title") String title,
			 	  @RequestParam("author") String author,
			 	 @RequestParam("cat") String cat)
	{
		Book b2=new Book();
		b2.setId(id);
		b2.setTitle(title);
		b2.setAuthor(author);
		b2.setCategory(cat);	
		
		return libraryService.addBook(b2);	
	}
	
	@PostMapping("/addBookByJson")
	public Book addBook(@RequestBody Book b2)
	{	
		return libraryService.addBook(b2);	
	}
	
	/*@PostMapping("/addBookByJson")
	public ResponseEntity<Book> addBook(@RequestBody Book b2)
	{	
		return new ResponseEntity<Book>(
				libraryService.addBook(b2),
				HttpStatus.OK
				);	
	}*/
	
	@GetMapping("/getBook")
	public Book getBook(@RequestParam("id") int id)
	{
		return libraryService.getBook(id);
	}
	
	@GetMapping("/getBookByPath/{pid}")
	public Book getBookByPath(@PathVariable("pid") int id)
	{
		return libraryService.getBook(id);
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBook()
	{
		return libraryService.getAllBooks();
	}
	
	@DeleteMapping("/deleteBook")
	public String deleteBook(@RequestParam("id") int id)
	{
		libraryService.deleteBook(id);
		return "Record Deleted";
	}
	
	@PutMapping("/updateBook")
	public Book updateBook(@RequestParam("bookid") int bid,
							@RequestBody Book b3)
	{
		return libraryService.updateBook(bid,b3);
	}
	
	@GetMapping("/getBookByAuthorNameUsingNativeQuery")
	public List<Book> getBookByAuthorName(@RequestParam("aname") String aname)
	{
		return libraryService.getBookByAuthorName(aname);
	}
	
	@GetMapping("/getBookByCategoryUsingJPAMethods")
	public List<Book> getBookByCategory(@RequestParam("cat") String category)
	{
		return libraryService.getBookByCategory(category);
	}
	
	
	//----
	@GetMapping("/list")
	public String listBook(Model theModel)
	{
		List<Book> listBooks=libraryService.getAllBooks();
		theModel.addAttribute("books",listBooks);
		return "books/list-books";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Book b1=new Book();
		theModel.addAttribute("book",b1);
		return "books/book-form";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book bz)
	{
		libraryService.addBook(bz);	
		return "redirect:/books/list";
	}
	
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int bid,
									Model theModel)
	{
		Book bookdb=libraryService.getBook(bid);
		theModel.addAttribute("book",bookdb);
		return "books/book-form";
	}
	
	@PostMapping("/delete")
	public String deleteMyBook(@RequestParam("bookId") int id)
	{
		libraryService.deleteBook(id);
		return "redirect:/books/list";
	}
	
	
}


