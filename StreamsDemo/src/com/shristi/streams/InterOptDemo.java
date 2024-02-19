package com.shristi.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class InterOptDemo {
	public static void main(String[] args) {
		
		Function<String, Integer> fun = str->str.length();
		
		
		List<String> courses = 
				Arrays.asList("java","spring","spring","angular","html","css","junit","javascript","react");
		
		courses.stream()
				.filter(str->str.length()>4)
				.sorted()
				.distinct()
				.skip(2)
				.forEach(str->System.out.println(str.toUpperCase()));

	System.out.println();
		courses.stream()
		.filter(str->str.length()>4)
		.sorted()
//		.map(str->str.toUpperCase())
		.map(str->str.length())
		.forEach(str->System.out.println(str));
	
	}

}
