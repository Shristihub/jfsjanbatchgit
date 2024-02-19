package com.shristi.streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateDemo {

	public static void main(String[] args) {
		
		Consumer<String> con = str->System.out.println(str.toUpperCase());
		
		
		List<String> courses = Arrays.asList("java","spring","angular","html","css","junit","javascript");
		
		// convert a list into a stream
		List<String> newcourses =  courses.stream().collect(Collectors.toList());
		System.out.println(newcourses);
		
		courses.stream().forEach(str->System.out.println(str.toUpperCase()));
		
		// convert an array of objects into a stream
		String[] arr = {"apple","orange"};
		Stream.of(arr).forEach(str->System.out.println(str));
		
		//convert an array of primitiva values into a stream
		int[] nums = new int[] {10,20,30,40,50,60,70,80};
		Arrays.stream(nums, 3, 8).forEach(num->System.out.println(num));
		
		
		Supplier<String> sup = ()-> "hello";
		
		//concat a stream
		Stream.concat(Stream.of("a","b","c","d"), Stream.of("hello","welcome")).forEach(str->System.out.println(str));
		
		// generate an infinite stream
		Iterator<String>  it =  Stream.generate(()-> "hello").limit(5).iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		
	}
}
