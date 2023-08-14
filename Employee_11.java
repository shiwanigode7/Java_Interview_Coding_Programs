package com.interview.problems.java.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// You have given list of employees, find out who has most working experience in the organization
public class Employee_11 {

	private int id;
	private String name;
	private int age;
	private Gender gender;
	private Department department;
	private int yearOfJoining;
	private double salary;

	public Employee_11(int id, String name, int age, Gender gender, Department department, int yearOfJoining,
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
		return "Employee_11 [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}

	private static List<Employee_11> EMPLOYEE_List = new ArrayList<Employee_11>();

	public static void main(String[] args) {

		EMPLOYEE_List.add(new Employee_11(1, "Shiwani", 31, Gender.FEMALE, Department.IT, 2018, 80000));
		EMPLOYEE_List.add(new Employee_11(2, "Mithun", 15, Gender.MALE, Department.FINANCE, 2000, 40000));
		EMPLOYEE_List.add(new Employee_11(3, "Prasad", 18, Gender.MALE, Department.HR, 2006, 2000));
		EMPLOYEE_List.add(new Employee_11(4, "Shwetangi", 20, Gender.FEMALE, Department.RND, 2010, 88000));
		EMPLOYEE_List.add(new Employee_11(5, "Vijay", 16, Gender.MALE, Department.SALES, 2022, 3000));
		EMPLOYEE_List.add(new Employee_11(6, "shaila", 45, Gender.FEMALE, Department.MARKETING, 2021, 90000));
		EMPLOYEE_List.add(new Employee_11(7, "Dhirendra", 25, Gender.MALE, Department.SALES, 2015, 100000));
		EMPLOYEE_List.add(new Employee_11(8, "Hanamanth", 59, Gender.MALE, Department.SALES, 2009, 5000));
		EMPLOYEE_List.add(new Employee_11(9, "Om", 45, Gender.MALE, Department.MANUFACTURING, 2003, 13000));
		EMPLOYEE_List.add(new Employee_11(10, "Liana", 23, Gender.FEMALE, Department.IT, 2023, 9000));

		Optional<Employee_11> seniorMostEmployeeWrapper = EMPLOYEE_List.stream()
				.sorted(Comparator.comparingInt(Employee_11::getYearOfJoining)).findFirst();

		Employee_11 seniorMostEmployee = seniorMostEmployeeWrapper.get();

		System.out.println("ID - " + seniorMostEmployee.getId());
		System.out.println("Name - " + seniorMostEmployee.getName());
	}
}

enum Gender {
	MALE, FEMALE
}

enum Department {
	MARKETING, HR, SALES, FINANCE, RND, IT, MANUFACTURING, QUALITY_MANAGEMENT
}