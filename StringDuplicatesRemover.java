package com.interview.problems.java.core;

import java.util.Arrays;
import java.util.stream.Stream;

// You have given list of strings, remove the duplicate string from the list 
public class StringDuplicatesRemover {
	private static String[] STRING_ARRAY = { "Meta", "Apple", "Amazon", "Netflix", "Apple", "Google", "Netflix" };

	public static void main(String[] args) {
		Stream<String> stringList = removeDuplicates();
		displayList(stringList);
	}

	private static Stream<String> removeDuplicates() {
		return Arrays.stream(STRING_ARRAY).distinct();
	}

	private static void displayList(Stream<String> stringList) {
		stringList.forEach(System.out::println);
	}
}
