package com.shristi.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreams {

	public static void main(String[] args) {
		
		IntStream instr = Arrays.stream(new int[] {10,20,30,40});
		int sum = instr.sum();
		System.out.println(sum);
		
		Arrays.stream(new int[] {10,20,30,40})
			  .average()
			  .ifPresent(num->System.out.println(num));
		
		long count = Arrays.stream(new int[] {10,20,30,40}).count();
		System.out.println(count);
		
		
		count = LongStream.range(100, 110).count();
		System.out.println(count);
		
		 Arrays.stream(new int[] {10,21,30,45})
		       .filter(num->num%2==0)
		       .forEach(System.out::println);
		
		System.out.println();
		List<String> courses = 
				Arrays.asList("java","spring","spring","angular","html","css","junit","javascript","react");
		
		List<Integer> numbers = courses.stream()
				.map(str->str.length()) // Stream<Integer>
//				.forEach(num->System.out.println(num));
				.collect(Collectors.toList());
				 
		 System.out.println(numbers);
		 
		int sum1 =  courses.stream()
//			.mapToInt(str->str.length()) // IntStream
			.mapToInt(String::length) // meth ref
			.sum();
		System.out.println(sum1);	
		
		
		Arrays.asList("100","200","400","900","priya")
		.stream()
//		.mapToInt(str->Integer.parseInt(str)) //"900" to 900
		.mapToInt(Integer::parseInt)
		.average()
//		.ifPresent(num->System.out.println(num));
		.ifPresent(System.out::println);
		
		
		
		
		
			
			
	}
}
