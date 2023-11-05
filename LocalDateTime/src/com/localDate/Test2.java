package com.localDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test2 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter date in format : dd/MM/yyyy");
		
		LocalDate dob=LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Specify the format explicitly
		System.out.println("dob: "+dob);
		
		
	}
}
