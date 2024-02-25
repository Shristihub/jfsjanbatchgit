package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements IBookService {

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(int bookId, double price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(int BookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByAuthorCategory(String author, String category) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



}
