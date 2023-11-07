package com.linkedlist;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;

public class TestEmp 
{
	public static void main(String[] args)
	{
		Emp e1=new Emp(105, "balaji", 45000, LocalDate.parse("1996-01-29"));
		Emp e2=new Emp(110, "balaji", 45000, LocalDate.parse("1996-01-29"));
		Emp e3=new Emp(103, "balaji", 45000, LocalDate.parse("1996-01-29"));
		
		LinkedList<Emp> empList=new LinkedList<>();
		Collections.addAll(empList, e1, e2, e3);
		
		System.out.println(empList.getFirst());
		System.out.println(empList.getLast());
	}
}
