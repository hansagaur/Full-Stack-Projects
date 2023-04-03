package com.greatlearning.lma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.lma.entity.Book;
import com.greatlearning.lma.repository.BookRepository;
import com.greatlearning.lma.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> findAll() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

}
