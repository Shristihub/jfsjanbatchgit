package com.inter.methref;

import java.util.function.Consumer;

public class ConstRefDemo {

	public static void main(String[] args) {
		// using a  class
		IShapeFactory factory = new ShapFactoryImpl();
		Shape shape = factory.printArea(10);
		shape.area();
		
		// using Lambda
		IShapeFactory factory1 = (x)-> new Shape(x);
		Shape shape1 =factory1.printArea(100);
		shape1.area();
		
		// using methodref - call constructor of shape class
		IShapeFactory factory2 = Shape::new;
		Shape shape2 =factory2.printArea(100);
		shape2.area();
		
//		Consumer<String> con = str->System.out.println(str);
		Consumer<String> con = System.out::println;
		con.accept("Priya");
		
	}
}
