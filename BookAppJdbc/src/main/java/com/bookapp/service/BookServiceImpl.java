package com.bookapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.dao.BookDaoImpl;
import com.bookapp.dao.IBookDao;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements IBookService {

	private IBookDao bookDao = new BookDaoImpl();

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void updateBook(int bookId, double price) {
		bookDao.updateBook(bookId, price);
	}

	@Override
	public void deleteBook(int bookId) {
		bookDao.deleteBook(bookId);
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		Book book = bookDao.findById(bookId);
		if (book == null) {
			throw new IdNotFoundException("invalid id");
		}
		return book;
	}

	@Override
	public List<Book> getAll() {
		List<Book> books = bookDao.findAll();
		return books;
	}

	@Override
	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		List<Book> books = bookDao.findByAuthor(author);
		// if list is empty throw exception
		if(books.isEmpty())
			throw new BookNotFoundException("Book by this author not available");
		// convert list to stream, sort and convert back to list
		return books.stream().sorted((b1,b2)->b1.getTitle().compareTo(b2.getTitle())).toList();
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		List<Book> books = bookDao.findByLesserPrice(price);
		if(books.isEmpty())
			throw new BookNotFoundException("Book lesser than this price not available");
		return books.stream().sorted((b1,b2)->b1.getTitle().compareTo(b2.getTitle())).toList();
	}

	@Override
	public List<Book> getByAuthorCategory(String author, String category) throws BookNotFoundException {
		List<Book> books = bookDao.findByAuthorCategory(author, category);
		if(books.isEmpty())
			throw new BookNotFoundException("Book by this author in this category not available\"");
		return books.stream().sorted((b1,b2)->b1.getTitle().compareTo(b2.getTitle())).toList();
	}

}
