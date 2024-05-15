package com.greatlearning.lma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.lma.entity.Book;
import com.greatlearning.lma.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		
		//get Books from DB
		List<Book> theBooks = bookService.findAll();
		
		//add Books to the spring model
		theModel.addAttribute("books", theBooks);
		
		return "books/list-books";
	}
	
	//addBooks
	//updateBooks
	//deleteBooks
}
