package com.bookapp.client;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class Customer {
	public static void main(String[] args) {
		IBookService bookService = new BookServiceImpl();
		
		System.out.println("Add few books");
		Book book = new Book("Magic","Rhonda",450,"selfhelp");
		bookService.addBook(book);
		Book book1 = new Book("5 am club","Robin",580,"selfhelp");
		bookService.addBook(book1);
		
		System.out.println();
		System.out.println("Get all Books");
		bookService.getAll().stream().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get By Author");
		try {
			List<Book> booksByAuthor = bookService.getByAuthor("Kathy");
			booksByAuthor.stream().forEach(nbook->System.out.println(nbook));
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println("Get By Lesser Price");
		try {
			List<Book> booksByPrice = bookService.getByLesserPrice(600);
			booksByPrice.stream().forEach(nbook->System.out.println(nbook.getTitle().toUpperCase()));
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println("Get By Author Category");
		try {
			List<Book> booksByAuthCat = bookService.getByAuthorCategory("Robin","Selfhelp");
			booksByAuthCat.stream().forEach(System.out::println);
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println("Get By Id");
		try {
			Book newbook = bookService.getById(20);
			System.out.println(newbook);
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println();
		System.out.println("Update Book");
		bookService.updateBook(1, 1200);
		
		
	}

}
