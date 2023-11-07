package com.linkedlist;
import java.time.LocalDate;

public class Emp 
{
	private int empNo;
	private String name;
	private double salary;
	private LocalDate dob;
	
	
	public Emp() 
	{
		super();
	}

	public Emp(int empNo, String name, double salary, LocalDate dob) 
	{
		super();
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
	}

	public int getEmpNo() 
	{
		return empNo;
	}

	public void setEmpNo(int empNo) 
	{
		this.empNo = empNo;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getSalary() 
	{
		return salary;
	}

	public void setSalary(double salary) 
	{
		this.salary = salary;
	}

	public LocalDate getDob() 
	{
		return dob;
	}

	public void setDob(LocalDate dob) 
	{
		this.dob = dob;
	}

	@Override
	public String toString() 
	{
		return "Emp [empNo=" + empNo + ", name=" + name + ", salary=" + salary + ", dob=" + dob + "]";
	}
	
	
	
	
	
	
}
