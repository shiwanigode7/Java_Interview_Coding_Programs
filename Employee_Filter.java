package com.interview.problems.java.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//find out the employee whose salary is < 10000 and born after 01/01/2000
public class Employee_Filter {

	private String name;
	private int age;
	private LocalDate dob;
	private long salary;

	public Employee_Filter(String name, int age, LocalDate dob, long salary) {
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
		return "Employee_Filter [name=" + name + ", age=" + age + ", dob=" + dob + ", salary=" + salary + "]";
	}

	public static void main(String[] args) {

		Employee_Filter employee1 = new Employee_Filter("Shiwani", 31, LocalDate.parse("1992-07-21"), 3000);
		Employee_Filter employee2 = new Employee_Filter("Prasad", 62, LocalDate.parse("1998-01-29"), 2000);
		Employee_Filter employee3 = new Employee_Filter("Mithun", 50, LocalDate.parse("2002-04-04"), 7000);
		Employee_Filter employee4 = new Employee_Filter("Emma", 24, LocalDate.parse("2010-06-11"), 65000);
		Employee_Filter employee5 = new Employee_Filter("Parag", 26, LocalDate.parse("1995-08-01"), 46000);
		Employee_Filter employee6 = new Employee_Filter("Kishor", 32, LocalDate.parse("2023-09-19"), 12000);
		Employee_Filter employee7 = new Employee_Filter("Wayu", 40, LocalDate.parse("2004-02-13"), 50000);
		Employee_Filter employee8 = new Employee_Filter("Om", 45, LocalDate.parse("2015-01-09"), 80000);

		List<Employee_Filter> employeeList = new ArrayList<Employee_Filter>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);
		employeeList.add(employee6);
		employeeList.add(employee7);
		employeeList.add(employee8);

		Map<Integer, List<Employee_Filter>> result = employeeList.stream()
				.collect(Collectors.groupingBy(employee -> employee.dob.compareTo(LocalDate.parse("2000-01-01")) < 0 ? -1
						: (employee.dob.compareTo(LocalDate.parse("2000-01-01")) == 0 ? 0 : 1)));
		
		//key--> -1 ---> will have employees with previous date
		//key--> 0 ---> will have employees with current date
		//key--> 1 ---> will have employees with future date
		List<Employee_Filter> sortedByDOBTestList = result.get(1);
		
		sortedByDOBTestList.stream().filter(employee -> employee.getSalary() < 10000).collect(Collectors.toList())
				.forEach(System.out::println);
	}
}
