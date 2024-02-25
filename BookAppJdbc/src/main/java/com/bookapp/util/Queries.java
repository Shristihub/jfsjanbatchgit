package com.bookapp.util;

public class Queries {

	public static final String INSERTQUERY = 
			   "INSERT INTO BOOK(title,author,price,category) VALUES(?,?,?,?)";
	public static final String UPDATEQUERY = "UPDATE BOOK SET price=? where bookId = ?";
	public static final String DELETEQUERY = "DELETE FROM BOOK where bookId = ?";
	
}
