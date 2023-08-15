package com.interview.problems.java.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// You have given list of employees, sort the employees by name and salary in descending order
public class Employee_19 {

	private int id;
	private String name;
	private int age;
	private Gender gender;
	private Department department;
	private int yearOfJoining;
	private double salary;

	public Employee_19(int id, String name, int age, Gender gender, Department department, int yearOfJoining,
			double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public Department getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee_19 [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}

	private static List<Employee_19> EMPLOYEE_LIST = new ArrayList<Employee_19>();

	public static void main(String[] args) {

		EMPLOYEE_LIST.add(new Employee_19(1, "Shiwani", 31, Gender.FEMALE, Department.IT, 2018, 80000));
		EMPLOYEE_LIST.add(new Employee_19(2, "Mithun", 15, Gender.MALE, Department.IT, 2000, 40000));
		EMPLOYEE_LIST.add(new Employee_19(3, "Prasad", 18, Gender.MALE, Department.HR, 2006, 2000));
		EMPLOYEE_LIST.add(new Employee_19(4, "Shwetangi", 20, Gender.FEMALE, Department.RND, 2010, 88000));
		EMPLOYEE_LIST.add(new Employee_19(5, "Vijay", 16, Gender.MALE, Department.SALES, 2022, 3000));
		EMPLOYEE_LIST.add(new Employee_19(6, "Shaila", 45, Gender.FEMALE, Department.MARKETING, 2021, 90000));
		EMPLOYEE_LIST.add(new Employee_19(7, "Dhirendra", 25, Gender.MALE, Department.SALES, 2015, 100000));
		EMPLOYEE_LIST.add(new Employee_19(8, "Hanamanth", 59, Gender.MALE, Department.SALES, 2009, 5000));
		EMPLOYEE_LIST.add(new Employee_19(9, "Om", 45, Gender.MALE, Department.MANUFACTURING, 2003, 13000));
		EMPLOYEE_LIST.add(new Employee_19(10, "Liana", 23, Gender.FEMALE, Department.IT, 2023, 9000));

		EMPLOYEE_LIST.sort(Comparator.comparingDouble(Employee_19::getSalary).reversed());

		System.out.println("Sorted By Salary");
		for (Employee_19 employee : EMPLOYEE_LIST) {
			System.out.println(employee.getName() + " - " + employee.getSalary());
		}
		System.out.println("=============================================");

		EMPLOYEE_LIST.sort(Comparator.comparing(Employee_19::getName).reversed());

		System.out.println("Sorted By Name");
		for (Employee_19 employee : EMPLOYEE_LIST) {
			System.out.println(employee.getName() + " - " + employee.getSalary());
		}
	}
}

enum Gender {
	MALE, FEMALE
}

enum Department {
	MARKETING, HR, SALES, FINANCE, RND, IT, MANUFACTURING, QUALITY_MANAGEMENT
}