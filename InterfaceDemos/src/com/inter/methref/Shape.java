package com.inter.methref;

public class Shape {

	int x;
	public Shape(int x) {
		this.x= x;
	}

	void area() {
		System.out.println("Sq " + (x * x));
	}
}
