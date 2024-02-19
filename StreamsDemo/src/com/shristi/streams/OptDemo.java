package com.shristi.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptDemo {
	public static void main(String[] args) {
		
		List<String> courses = Arrays.asList("java","spring","angular","html");
		Optional<String> opt = courses.stream()
		     .filter(str->str.startsWith("a"))
		     .findFirst();
		
		// using get method if value present print it else throw NoSUchElementException
//		System.out.println(opt.get());
		
		System.out.println("...using if present....");
		// if value is present print the value
		opt.ifPresent(str-> System.out.println(str.toUpperCase()));
		System.out.println("...using if present or else....");
		
		// if value is present print the value  else print substitute value
		opt.ifPresentOrElse(str-> System.out.println(str.toUpperCase()),
				            ()->System.out.println("some dummy value"));
		
		if(!opt.isEmpty())
			System.out.println(opt.get());
		
		if(opt.isPresent())
			System.out.println(opt.get());
		System.out.println();
		
		System.out.println("...using or else....");
		String strval = Arrays.asList("java","spring","angular","html")
		.stream()
		.filter(str->str.startsWith("q"))
		.findFirst()
		.orElse("dummy");
		System.out.println(strval);
		
		
		System.out.println("...using or elseget....");
		String strval1 = Arrays.asList("java","spring","angular","html")
		.stream()
		.filter(str->str.startsWith("d"))
		.findFirst()
		.orElseGet(()->"somme substitute value");
		System.out.println(strval1);
		
	}

}
