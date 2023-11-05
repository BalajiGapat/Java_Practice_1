package com.localDate;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;


public class Test3 {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
	
		System.out.println("enter date Of Birth: ");
		LocalDate date2=LocalDate.parse(sc.next());
		
		int year=Period.between(date2, LocalDate.now() ).getYears();
		System.out.println("year: "+year);
		
		int month=Period.between(date2, LocalDate.now() ).getMonths();
		System.out.println("month: "+Math.abs(month));
		
		int day=Period.between(date2, LocalDate.now() ).getDays();
		System.out.println("day: "+day);


	}
	

}
