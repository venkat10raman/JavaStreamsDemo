package com.venkat;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private int id;
	private String name;
	private double percentage;
	private String specialization;
	
	public Student() {}
	
	public Student(int id, String name, double percentage, String specialization) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.specialization = specialization;
    }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPercentage() {
		return percentage;
	}

	public String getSpecialization() {
		return specialization;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", percentage=" + percentage + ", specialization="
				+ specialization + "]";
	}
	
	public List<Student> loadStudents() {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(111, "John", 81.0, "Mathematics"));
		studentList.add(new Student(222, "Harsha", 79.5, "History"));
		studentList.add(new Student(333, "Ruth", 87.2, "Computers"));
		studentList.add(new Student(444, "Aroma", 63.2, "Mathematics"));
		studentList.add(new Student(555, "Zade", 83.5, "Computers"));
		studentList.add(new Student(666, "Xing", 58.5, "Geography"));
		studentList.add(new Student(777, "Richards", 72.6, "Banking"));
		studentList.add(new Student(888, "Sunil", 86.7, "History"));
		studentList.add(new Student(999, "Jordan", 58.6, "Finance"));
		studentList.add(new Student(101010, "Chris", 89.8, "Computers"));
		return studentList;
	}
	
}
