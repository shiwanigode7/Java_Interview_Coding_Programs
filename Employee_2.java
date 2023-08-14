package com.interview.problems.java.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//You have given list of employees, find out all the employees whose designation is “Manager” and age is above 30.
public class Employee {

	private long empId;
	private String name;
	private int age;
	private Designation designation;

	public Employee(long empId, String name, int age, Designation designation) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.designation = designation;
	}

	public long getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Designation getDesignation() {
		return designation;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", designation=" + designation
				+ "]";
	}

	private static List<Employee> EMPLOYEE_List = new ArrayList<Employee>();

	public static void main(String[] args) {

		EMPLOYEE_List.add(new Employee(1, "Robert", 35, Designation.CEO));
		EMPLOYEE_List.add(new Employee(2, "Martin", 35, Designation.MANAGER));
		EMPLOYEE_List.add(new Employee(5, "Jack", 25, Designation.CTO));
		EMPLOYEE_List.add(new Employee(3, "Akshay", 20, Designation.GENERAL_MANAGER));
		EMPLOYEE_List.add(new Employee(8, "Arvind", 40, Designation.SOFTWARE_ENGINEER));
		EMPLOYEE_List.add(new Employee(9, "Dinesh", 45, Designation.MANAGER));

		EMPLOYEE_List.stream()
				.filter(employee -> Designation.MANAGER.equals(employee.getDesignation()) && employee.getAge() > 30)
				.collect(Collectors.toList()).forEach(System.out::println);
	}
}

enum Designation {
	COO, CEO, CTO, VISE_PRESIDENT, SOFTWARE_ENGINEER, MANAGER, GENERAL_MANAGER
}
