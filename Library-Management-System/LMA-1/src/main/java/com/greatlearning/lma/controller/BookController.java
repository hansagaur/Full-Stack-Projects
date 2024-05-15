package com.greatlearning.lma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.lma.entity.Book;
import com.greatlearning.lma.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		
		//get books from DB
		List<Book> theBooks = bookService.findAll(); 
		
		//add to the spring model
		theModel.addAttribute("books", theBooks);
		
		return "books/list-books";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind the data
		Book theBook = new Book();
		
		theModel.addAttribute("book", theBook);
		
		return "books/book-form";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book theBook) {
		
		//save the book
		bookService.save(theBook);

		return "redirect:/books/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId, 
			Model model) {
		//get the book from the service
		Book theBook = bookService.findById(theId);
	
		//set the book as a model attribute to pre-populate the form
		model.addAttribute("book", theBook);
		
		//send over to book form page
		return "books/book-form";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("bookId") int theId) {
		//delete the book
		bookService.deleteById(theId);
		
		//redirect to /books/list in controller 
		return "redirect:/books/list";
	}
	
}
