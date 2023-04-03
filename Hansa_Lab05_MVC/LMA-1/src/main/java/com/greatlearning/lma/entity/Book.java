package com.greatlearning.lma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "title")
	private String title;

	@Column(name = "category")
	private String category;

	@Column(name = "author")
	private String author;

	public Book() {
	}

	public Book(String title, String category, String author) {
		this.title = title;
		this.category = category;
		this.author = author;
	}
	
	  public String getTitle() {
		  return title; 
	  }
	  
	  public void setTitle(String title) { 
		  this.title = title; 
	  }
	  
	  public String getCategory() { 
		  return category; 
	  }
	  
	  public void setCategory(String category) { 
		  this.category = category; 
	  }
	  
	  public String getAuthor() { 
		  return author; 
	  }
	  
	  public void setAuthor(String author) { 
		  this.author = author; 
	  }
	 

}
