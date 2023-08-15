package com.interview.problems.java.core;

import java.util.Arrays;
import java.util.List;

//Given a list of integers, find out all the even numbers that exist in the list using stream functions
public class EvenNumberFinder {

	private static List<Integer> NUMBER_LIST = Arrays.asList(1, 67, 8, 0, 9, 54, 87, 65, 7, 65, 44);

	public static void main(String[] args) {
		List<Integer> evenNumberList = findEvenNumbers();
		displayEvenNumberList(evenNumberList);
	}

	private static List<Integer> findEvenNumbers() {
		return NUMBER_LIST.stream().filter(number -> number % 2 == 0).toList();
	}

	private static void displayEvenNumberList(List<Integer> evenNumberList) {
		System.out.println(evenNumberList);
	}
}
