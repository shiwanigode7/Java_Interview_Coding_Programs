package com.interview.problems.java.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//You have given list of employees, find out all the employees whose designation is “Manager” and age is above 30.
public class Employee {

	private long empId;
	private String name;
	private int age;
	private String designation;

	public Employee(long empId, String name, int age, String designation) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.designation = designation;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", designation=" + designation
				+ "]";
	}

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Robert", 35, "Manager"));
		empList.add(new Employee(2, "Martin", 35, "General Manager"));
		empList.add(new Employee(5, "Jack", 25, "Manager"));
		empList.add(new Employee(3, "Akshay", 20, "Developer"));
		empList.add(new Employee(8, "Arvind", 40, "Manager"));
		empList.add(new Employee(9, "Dinesh", 45, "Manager"));

		empList.stream()
				.filter(employee -> "Manager".equalsIgnoreCase(employee.getDesignation()) && employee.getAge() > 30)
				.collect(Collectors.toList()).forEach(System.out::println);
	}
}
