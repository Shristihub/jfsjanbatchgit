package com.inter.methref;

class Operations{
	static void add(int x, int y) {
		System.out.println("Sum "+(x+y));
	}
	void product(int x, int y) {
		System.out.println("Product "+(x*y));
	}
}

public class RefDemo {

	public static void main(String[] args) {
		// Refer to a static method
		IMethCalculator addOper = Operations::add;
		// this will be called first
		addOper.calculate(10,20);
		
		// Refer to a non-static method
		Operations oprs = new Operations();
		// refer the method using obj
		IMethCalculator productOper = oprs::product;
		// this iwll be called first
		productOper.calculate(1, 2);
		
		
	}
}
