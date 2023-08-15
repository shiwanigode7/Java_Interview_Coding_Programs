package com.interview.problems.java.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

// You have given list of employees, separate the employees who are younger or equal to 25 years from those employees who are older than 25 years
public class Employee {

	private int id;
	private String name;
	private int age;
	private Gender gender;
	private Department department;
	private int yearOfJoining;
	private double salary;

	public Employee(int id, String name, int age, Gender gender, Department department, int yearOfJoining,
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
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}

	private static List<Employee> EMPLOYEE_LIST = new ArrayList<Employee>();

	public static void main(String[] args) {

		EMPLOYEE_LIST.add(new Employee(1, "Shiwani", 31, Gender.FEMALE, Department.IT, 2018, 80000));
		EMPLOYEE_LIST.add(new Employee(2, "Mithun", 15, Gender.MALE, Department.IT, 2000, 40000));
		EMPLOYEE_LIST.add(new Employee(3, "Prasad", 18, Gender.MALE, Department.HR, 2006, 2000));
		EMPLOYEE_LIST.add(new Employee(4, "Shwetangi", 20, Gender.FEMALE, Department.RND, 2010, 88000));
		EMPLOYEE_LIST.add(new Employee(5, "Vijay", 16, Gender.MALE, Department.SALES, 2022, 3000));
		EMPLOYEE_LIST.add(new Employee(6, "shaila", 45, Gender.FEMALE, Department.MARKETING, 2021, 90000));
		EMPLOYEE_LIST.add(new Employee(7, "Dhirendra", 25, Gender.MALE, Department.SALES, 2015, 100000));
		EMPLOYEE_LIST.add(new Employee(8, "Hanamanth", 59, Gender.MALE, Department.SALES, 2009, 5000));
		EMPLOYEE_LIST.add(new Employee(9, "Om", 45, Gender.MALE, Department.MANUFACTURING, 2003, 13000));
		EMPLOYEE_LIST.add(new Employee(10, "Liana", 23, Gender.FEMALE, Department.IT, 2023, 9000));

		Map<Boolean, List<Employee>> partitionEmployeesByAge = EMPLOYEE_LIST.stream()
				.collect(Collectors.partitioningBy(employee -> employee.getAge() > 25));

		Set<Entry<Boolean, List<Employee>>> entrySet = partitionEmployeesByAge.entrySet();
		for (Entry<Boolean, List<Employee>> entry : entrySet) {

			System.out.println("======================================");

			if (entry.getKey()) {
				System.out.println("Employees older than 25 years");
			} else {
				System.out.println("Employees younger than or equal to 25 years");
			}

			System.out.println("======================================");

			List<Employee> employeeList = entry.getValue();

			for (Employee employee : employeeList) {
				System.out.println(employee.getName());
			}
		}

	}
}

enum Gender {
	MALE, FEMALE
}

enum Department {
	MARKETING, HR, SALES, FINANCE, RND, IT, MANUFACTURING, QUALITY_MANAGEMENT
}
