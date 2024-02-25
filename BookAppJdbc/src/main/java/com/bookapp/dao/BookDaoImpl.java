package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDb;
import com.bookapp.util.Queries;

// from here connect to db
public class BookDaoImpl implements IBookDao{

	@Override
	public void addBook(Book book) {
		// establish connection
		// create a prepared statement
		// set the values for placeholder
		// execute the query
		// close the connection
		
		try (Connection connection = BookDb.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);){ // create a prepared statement
			statement.setString(1, book.getTitle()); //set the values for placeholder
			statement.setString(2, book.getAuthor());
			statement.setDouble(3, book.getPrice());
			statement.setString(4, book.getCategory());
			statement.execute();  //execute the query
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	
	@Override
	public void updateBook(int bookId, double price) {
		
		
	}

	@Override
	public void deleteBook(int BookId) {
		
		
	}

	@Override
	public Book findById(int bookId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByAuthor(String author) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByLesserPrice(double price) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByAuthorCategory(String author, String category) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
