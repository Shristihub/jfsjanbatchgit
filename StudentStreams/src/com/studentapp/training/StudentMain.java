package com.studentapp.training;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StudentMain {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("Roni", 1, "CSE", "Bangalore"),
				new Student("Kevin", 2, "ECE", "Chennai"),
				new Student("Vinay", 3, "IT", "Bangalore"),
				new Student("Joe", 4, "CSE", "Cochin"),
				new Student("Mayil", 5, "CSE", "Chennai"),
				new Student("Ayaz", 6, "CSE", "Bangalore"));
		
		
//		Function<Student, Integer> fun1 = student-> student.getStudentId();
//		System.out.println(fun1.apply(new Student("Roni", 1, "CSE", "Bangalore")));
//		System.out.println();
//
//		Function<Student, String> fun2 = student->"hi";
//		System.out.println(fun2.apply(new Student("Roni", 1, "CSE", "Bangalore")));
//		
//		Function<List<Student>,Student> fun3 = studlist->new Student("Roni", 1, "CSE", "Bangalore");
//		System.out.println(fun3.apply(studentList));
//		
//		Function<List<Student>,List<String>> fun4 = studlist->Arrays.asList("java");
//		System.out.println(fun4.apply(studentList));
//		
//		
//		
		
		
		System.out.println();
		System.out.println();
		System.out.println("print all students");
		studentList.stream().forEach(student->System.out.println(student));
		System.out.println();
		System.out.println("print students by department");
		studentList.stream()
					.filter(student->student.getDepartment().equals("CSE"))
					.forEach(student->System.out.println(student));
		System.out.println();
		System.out.println("print student by id ");
		studentList.stream()
				.filter(student->student.getStudentId()==1)// get id and compare with id
				.findFirst()
				.ifPresent(student->System.out.println(student));
		System.out.println();
		System.out.println("print student names by city ");
		studentList.stream()
				.filter(student->student.getCity().equals("Chennai"))
				.map(student-> student.getName())
				.forEach(student->System.out.println(student));

		System.out.println();
		System.out.println("print all students");
		studentList.stream()
		.sorted((o1,o2)->o1.getName().compareTo(o2.getName()))
		.map(student-> student.getName())
		.forEach(student->System.out.println(student));
		
					
				
				

	}

}
