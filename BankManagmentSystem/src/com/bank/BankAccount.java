package com.bank;

import java.time.LocalDate;
import custom_exception.BankingException;
import static utils.ValidateAllInputs.checkMinBal;
public class BankAccount 
{

	private static long AUTOINCREMET;
	private static final String IFSC;
	private static final String BANKNAME;
	
	private long accountNo;
	private String customerName;
	private AcctType type;
	private double balance;
	private LocalDate createdOn;
	private LocalDate lastUpdated;
	private boolean isActive;
	
	static
	{
		AUTOINCREMET=0;
		IFSC="SBIN0004451";
		BANKNAME="STATE BANK OF INDIA";
	}

	public BankAccount() 
	{
		super();
	}

	public BankAccount(long accountNo, String customerName, AcctType type, double balance, LocalDate createdOn) 
	{
		super();
		this.accountNo=accountNo;
		this.customerName = customerName;
		this.type = type;
		this.balance = balance;
		this.createdOn = createdOn;
		this.lastUpdated =this.createdOn;
		this.isActive = true;
		
		++AUTOINCREMET;
	}
	
	public static long getAutoIncremet() {
		return AUTOINCREMET;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public AcctType getType() {
		return type;
	}

	public void setType(AcctType type) {
		this.type = type;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public static String getIfsc() {
		return IFSC;
	}

	public static String getBankname() {
		return BANKNAME;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	@Override
	public String toString() 
	{
		return "BankAccount [accoutNo=" + accountNo + ", customerName=" + customerName + ", Balance=" + balance +", IFSC CODE="+IFSC+ ", Bank Name="+BANKNAME+", AccountType="
				+ type + ", createdOn=" + createdOn + ", lastUpdated=" + lastUpdated + ", isActive=" + isActive
				+ "]";
	}
	
	
	public void deposit(double amount) throws BankingException
	{
		if(this.isActive)
		{
			this.balance=balance+amount;
			lastUpdated=LocalDate.now();
		}
		else 
			throw new BankingException("Inactive Account...!!!");
	}
	
	public void withdraw(double amount) throws BankingException
	{
		if(this.isActive)
		{
			checkMinBal(balance-amount);
			this.balance=balance-amount;
			lastUpdated=LocalDate.now();
		}
		else 
			throw new BankingException("Inactive Account...!!!");
	}
	
	public void fundTransfer(BankAccount dest, double amount) throws BankingException
	{
		if(this.isActive && dest.isActive)
		{
			this.withdraw(amount);
			dest.deposit(amount);
		}
		else
			throw new BankingException("Inactive Account number...!!!");
	}
		
}
