package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDb;
import com.bookapp.util.Queries;

// from here connect to db
public class BookDaoImpl implements IBookDao {

	@Override
	public void addBook(Book book) {
		// establish connection
		// create a prepared statement
		// set the values for placeholder
		// execute the query
		// close the connection

		try (Connection connection = BookDb.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);) { // create a prepared
																									// statement
			statement.setString(1, book.getTitle()); // set the values for placeholder
			statement.setString(2, book.getAuthor());
			statement.setDouble(3, book.getPrice());
			statement.setString(4, book.getCategory());
			statement.execute(); // execute the query
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateBook(int bookId, double price) {
		try (Connection connection = BookDb.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);) {
			statement.setDouble(1, price); // set the values for placeholder
			statement.setInt(2, bookId);
			statement.execute(); // execute the query
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void deleteBook(int bookId) {
		try (Connection connection = BookDb.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);) { // create a prepared
																									// statement
			statement.setInt(1, bookId);
			statement.execute(); // execute the query
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Book findById(int bookId) throws IdNotFoundException {
		try (Connection connection = BookDb.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.SELECTBYIDQUERY);) {
			statement.setInt(1, bookId);
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					// create a book object
					// populate the properties with values from columns
					Book book = new Book();
//					String title = resultSet.getString("title");
					book.setTitle(resultSet.getString("title"));
					book.setAuthor(resultSet.getString("author"));
					book.setCategory(resultSet.getString(5));
					book.setBookId(resultSet.getInt(1));
					book.setPrice(resultSet.getDouble("price"));
					return book;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Book> findAll() {
		// create a List of books using array list
		List<Book> bookList = new ArrayList<Book>();
		try (Connection connection = BookDb.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.SELECTQUERY);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				// extract the values from the columns for one by one row
				int bookId = resultSet.getInt("book_id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");

				// assign the column values to book object
				// create a book object and populate with values
				Book book = new Book();
				book.setTitle(title);
				book.setAuthor(author);
				book.setCategory(category);
				book.setBookId(bookId);
				book.setPrice(price);

				// add the book object to the list
				bookList.add(book);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return bookList;
	}

	@Override
	public List<Book> findByAuthor(String author) throws BookNotFoundException {
		// create a List of books using array list
		List<Book> bookList = new ArrayList<Book>();
		try (Connection connection = BookDb.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.SELECTBYAUTHORQUERY);) {
			statement.setString(1, author);
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					// create a book object
					// populate the properties with values from columns
					Book book = new Book();
//				String title = resultSet.getString("title");
					book.setTitle(resultSet.getString("title"));
					book.setAuthor(resultSet.getString("author"));
					book.setCategory(resultSet.getString(5));
					book.setBookId(resultSet.getInt(1));
					book.setPrice(resultSet.getDouble("price"));
					bookList.add(book);
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return bookList;
	}

	@Override
	public List<Book> findByLesserPrice(double price) throws BookNotFoundException {
		// create a List of books using array list
		List<Book> bookList = new ArrayList<Book>();
		try (Connection connection = BookDb.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.SELECTBYPRICEQUERY);) {
			statement.setDouble(1, price);
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					// create a book object
					// populate the properties with values from columns
					Book book = new Book();
//				String title = resultSet.getString("title");
					book.setTitle(resultSet.getString("title"));
					book.setAuthor(resultSet.getString("author"));
					book.setCategory(resultSet.getString(5));
					book.setBookId(resultSet.getInt(1));
					book.setPrice(resultSet.getDouble("price"));
					bookList.add(book);
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return bookList;
	}

	@Override
	public List<Book> findByAuthorCategory(String author, String category) throws BookNotFoundException {
		// create a List of books using array list
		List<Book> bookList = new ArrayList<Book>();
		try (Connection connection = BookDb.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.SELECTBYAUTHCATQUERY);) {
			statement.setString(1, author);
			statement.setString(2, category);
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					// create a book object
					// populate the properties with values from columns
					Book book = new Book();
//				String title = resultSet.getString("title");
					book.setTitle(resultSet.getString("title"));
					book.setAuthor(resultSet.getString("author"));
					book.setCategory(resultSet.getString(5));
					book.setBookId(resultSet.getInt(1));
					book.setPrice(resultSet.getDouble("price"));
					bookList.add(book);
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return bookList;
	}

}
