package com.venkat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StudentManagement {
	
	public void usePredicate() {
		List<Student> studentList = new Student().loadStudents();
		List<Student> mathematicsStudents = new ArrayList<Student>();
		Predicate<Student> mathPredicate = 
			 student -> student.getSpecialization().equalsIgnoreCase("Mathematics");
		for(Student s : studentList) {
			if(mathPredicate.test(s)) {
				mathematicsStudents.add(s);
			}
		}
		System.out.println(mathematicsStudents);
	}
	
	public void useConsumer() {
		List<Student> studentList = new Student().loadStudents();
		Consumer<Student> consumer = student -> System.out.println(student.getName()+" : "+student.getPercentage());
		for(Student s : studentList) {
			consumer.accept(s);
		}
	}

	public void useFunction() {
		List<Student> studentList = new Student().loadStudents();
		Function<Student, String> nameFunction = Student::getName;
		for(Student s : studentList) {
			System.out.println(nameFunction.apply(s));
		}
	}
	
	public void useSupplier() {
		Supplier<Student> studentSupplier = Student::new;
		studentSupplier = () -> new Student(111111, "New Student", 92.9, "Java 8");
		System.out.println(studentSupplier.get());
	}
}
