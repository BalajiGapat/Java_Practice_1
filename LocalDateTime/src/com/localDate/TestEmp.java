package com.localDate;

import java.time.LocalDate;
import java.util.Scanner;
import static java.time.LocalDate.parse;


class Emp
{
	private int empNo;
	private String ename;
	private String address;
	private LocalDate dob;
	private double salary;
	
	public Emp()
	{
		
	}
	
	public Emp(int empNo, String ename, String address, LocalDate dob, double salary)
	{
		this.empNo=empNo;
		this.ename=ename;
		this.address=address;
		this.dob=dob;
		this.salary=salary;
	}
	
	@Override
	public String toString()
	{
		return "empno: "+empNo+", ename: "+ename+", Address: "+address+", dob: "+dob+", salary:"+salary;
	}

	
	public boolean equals(Object obj)
	{
		Emp e= (Emp) obj; // down casting
		
		//return this.empNo==e.empNo; equality on Primary key
		return this.empNo==e.empNo && this.ename.equals(e.ename) && this.dob.equals(e.dob) && this.salary==e.salary;
	}
	
}



public class TestEmp
{
	public static void main(String[] args) 
	{
		Emp e1=new Emp();
		System.out.println(e1);

		Scanner sc=new Scanner(System.in);
		
		System.out.println("\nEnter Emp details:: empNo, full name, full address(village and district),  dob(yyyy-mm-dd), salary");
		int empNo=sc.nextInt();
		sc.nextLine(); // to consume a newline character (i.e enter key press)
		String ename=sc.nextLine();
		String address=sc.nextLine();
		LocalDate dob=parse( sc.next() );
		double salary=sc.nextDouble();
		
		Emp e2=new Emp(empNo, ename, address, dob, salary);
		System.out.println(e2);
		
		System.out.println("\nEnter Emp details:: empNo, firstName(only), address(village only),  dob(yyyy-mm-dd), salary");
		Emp e3=new Emp(sc.nextInt(), sc.next(), sc.next(), parse(sc.next()), sc.nextDouble() );
		System.out.println(e3);

	}
}
