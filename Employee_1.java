package com.interview.problems.java.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//find out the employees whose salary is < 10000 and born after 01/01/2000
public class Employee {

	private String name;
	private int age;
	private LocalDate dob;
	private long salary;

	public Employee(String name, int age, LocalDate dob, long salary) {
		super();
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public LocalDate getDob() {
		return dob;
	}

	public long getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", dob=" + dob + ", salary=" + salary + "]";
	}

	private static List<Employee> EMPLOYEE_List = new ArrayList<Employee>();

	public static void main(String[] args) {

		EMPLOYEE_List.add(new Employee("Shiwani", 31, LocalDate.parse("1992-07-21"), 3000));
		EMPLOYEE_List.add(new Employee("Prasad", 62, LocalDate.parse("1998-01-29"), 2000));
		EMPLOYEE_List.add(new Employee("Mithun", 50, LocalDate.parse("2002-04-04"), 7000));
		EMPLOYEE_List.add(new Employee("Emma", 24, LocalDate.parse("2010-06-11"), 65000));
		EMPLOYEE_List.add(new Employee("Parag", 26, LocalDate.parse("1995-08-01"), 46000));
		EMPLOYEE_List.add(new Employee("Kishor", 32, LocalDate.parse("2023-09-19"), 12000));
		EMPLOYEE_List.add(new Employee("Wayu", 40, LocalDate.parse("2004-02-13"), 50000));
		EMPLOYEE_List.add(new Employee("Om", 45, LocalDate.parse("2015-01-09"), 80000));

		Map<Integer, List<Employee>> result = EMPLOYEE_List.stream()
				.collect(Collectors.groupingBy(
						employee -> employee.dob.compareTo(LocalDate.parse("2000-01-01")) < 0 ? -1
								: (employee.dob.compareTo(LocalDate.parse("2000-01-01")) == 0 ? 0 : 1)));

		// key--> -1 ---> will have Employees with previous date
		// key--> 0 ---> will have Employees with current date
		// key--> 1 ---> will have Employees with future date
		List<Employee> sortedByDOBTestList = result.get(1);

		sortedByDOBTestList.stream().filter(employee -> employee.getSalary() < 10000)
				.collect(Collectors.toList()).forEach(System.out::println);
	}
}
