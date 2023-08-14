package com.interview.problems.java.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee_3 {

	private int id;
	private String name;
	private int age;
	private Gender gender;
	private Department department;
	private int yearOfJoining;
	private double salary;

	public Employee_3(int id, String name, int age, Gender gender, Department department, int yearOfJoining,
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
		return "Employee_3 [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}

	private static List<Employee_3> EMPLOYEE_List = new ArrayList<Employee_3>();

	public static void main(String[] args) {

		EMPLOYEE_List.add(new Employee_3(1, "Shiwani", 31, Gender.FEMALE, Department.IT, 2018, 80000));
		EMPLOYEE_List.add(new Employee_3(2, "Mithun", 15, Gender.MALE, Department.FINANCE, 2000, 40000));
		EMPLOYEE_List.add(new Employee_3(3, "Prasad", 18, Gender.MALE, Department.HR, 2006, 2000));
		EMPLOYEE_List.add(new Employee_3(4, "Shwetangi", 20, Gender.FEMALE, Department.RND, 2010, 88000));
		EMPLOYEE_List.add(new Employee_3(5, "Vijay", 16, Gender.MALE, Department.SALES, 2022, 3000));
		EMPLOYEE_List.add(new Employee_3(6, "shaila", 45, Gender.FEMALE, Department.MARKETING, 2021, 90000));
		EMPLOYEE_List.add(new Employee_3(7, "Dhirendra", 25, Gender.MALE, Department.SALES, 2015, 100000));
		EMPLOYEE_List.add(new Employee_3(8, "Hanamanth", 59, Gender.MALE, Department.QUALITY_MANAGEMENT, 2009, 5000));
		EMPLOYEE_List.add(new Employee_3(9, "Om", 45, Gender.MALE, Department.MANUFACTURING, 2003, 13000));
		EMPLOYEE_List.add(new Employee_3(10, "Liana", 23, Gender.FEMALE, Department.IT, 2023, 9000));

		// no of male & female employees
		Map<Gender, Long> noOfMaleAndFemaleEmployees = EMPLOYEE_List.stream()
				.collect(Collectors.groupingBy(Employee_3::getGender, Collectors.counting()));
		System.out.println("No of male & female employess: " + noOfMaleAndFemaleEmployees);

		// no of male employees
		long noOfMaleEmployees = EMPLOYEE_List.stream().filter(employee -> employee.getGender().equals(Gender.MALE))
				.count();
		System.out.println("No of male employess: " + noOfMaleEmployees);

		// no of male employees
		long noOfFemaleEmployees = EMPLOYEE_List.stream().filter(employee -> employee.getGender().equals(Gender.FEMALE))
				.count();
		System.out.println("No of female employess: " + noOfFemaleEmployees);
	}

}

enum Gender {
	MALE, FEMALE
}

enum Department {
	MARKETING, HR, SALES, FINANCE, RND, IT, MANUFACTURING, QUALITY_MANAGEMENT
}