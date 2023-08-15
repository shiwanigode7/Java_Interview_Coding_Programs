package com.interview.problems.java.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

public class AgeCalculator {

	public static void main(String args[]) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your date of birth in dd-MM-yyyy format: ");
		String dob = sc.next();

		Date date = convertStringToDate(dob);
		Period period = calculateAge(date);

		System.out.print("your current age is: ");
		System.out.print(
				period.getYears() + " years, " + period.getMonths() + " months and " + period.getDays() + " days");
	}

	private static Date convertStringToDate(String dob) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.parse(dob);
	}

	private static Period calculateAge(Date date) {
		Instant instant = date.toInstant();
		ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
		LocalDate givenDate = zone.toLocalDate();

		return Period.between(givenDate, LocalDate.now());
	}
}