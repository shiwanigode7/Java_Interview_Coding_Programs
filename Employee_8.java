package com.interview.problems.java.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

// You have given list of employees, count the number of employees in each department
public class Employee_8 {

	private int id;
	private String name;
	private int age;
	private Gender gender;
	private Department department;
	private int yearOfJoining;
	private double salary;

	public Employee_8(int id, String name, int age, Gender gender, Department department, int yearOfJoining,
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
		return "Employee_8 [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}

	private static List<Employee_8> EMPLOYEE_List = new ArrayList<Employee_8>();

	public static void main(String[] args) {

		EMPLOYEE_List.add(new Employee_8(1, "Shiwani", 31, Gender.FEMALE, Department.IT, 2018, 80000));
		EMPLOYEE_List.add(new Employee_8(2, "Mithun", 15, Gender.MALE, Department.FINANCE, 2000, 40000));
		EMPLOYEE_List.add(new Employee_8(3, "Prasad", 18, Gender.MALE, Department.HR, 2006, 2000));
		EMPLOYEE_List.add(new Employee_8(4, "Shwetangi", 20, Gender.FEMALE, Department.RND, 2010, 88000));
		EMPLOYEE_List.add(new Employee_8(5, "Vijay", 16, Gender.MALE, Department.SALES, 2022, 3000));
		EMPLOYEE_List.add(new Employee_8(6, "shaila", 45, Gender.FEMALE, Department.MARKETING, 2021, 90000));
		EMPLOYEE_List.add(new Employee_8(7, "Dhirendra", 25, Gender.MALE, Department.SALES, 2015, 100000));
		EMPLOYEE_List.add(new Employee_8(8, "Hanamanth", 59, Gender.MALE, Department.SALES, 2009, 5000));
		EMPLOYEE_List.add(new Employee_8(9, "Om", 45, Gender.MALE, Department.MANUFACTURING, 2003, 13000));
		EMPLOYEE_List.add(new Employee_8(10, "Liana", 23, Gender.FEMALE, Department.IT, 2023, 9000));

		Map<Department, Long> employeeCountByDepartment = EMPLOYEE_List.stream()
				.collect(Collectors.groupingBy(Employee_8::getDepartment, Collectors.counting()));

		Set<Entry<Department, Long>> entrySet = employeeCountByDepartment.entrySet();

		for (Entry<Department, Long> entry : entrySet) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}

	}

}

enum Gender {
	MALE, FEMALE
}

enum Department {
	MARKETING, HR, SALES, FINANCE, RND, IT, MANUFACTURING, QUALITY_MANAGEMENT
}