package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import com.bank.AcctType;
import com.bank.BankAccount;
import custom_exception.BankingException;

public class ValidateAllInputs 
{
	private static double MIN_BALANCE;
	
	static
	{
		MIN_BALANCE=1000;
	}
	
	
	
	public static BankAccount validateAllInputs(long accountNo, String customerName, String accountType, double balance, String createdOn, HashMap<Long, BankAccount> bankMap) throws BankingException
	{
		checkforDuplicates(accountNo, bankMap);
		AcctType acctType=parseAndValidateAccountType(accountType);
		checkMinBal(balance);
		LocalDate date=parseCreatedDate(createdOn);
	
		return new BankAccount(accountNo, customerName, acctType, balance, date);
	}

	
	
	private static void checkforDuplicates(long accountNo, HashMap<Long, BankAccount> bankMap) throws BankingException 
	{
		if(bankMap.containsKey(accountNo))
			throw new BankingException("Duplicate account Number...!!!");
	}



	public static LocalDate parseCreatedDate(String createdOn) 
	{
		LocalDate date=LocalDate.parse(createdOn, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return date;
	}



	public static void checkMinBal(double balance) throws BankingException 
	{
		if(balance<MIN_BALANCE)
			throw new BankingException("min balance ritched...!!!");
	}



	public static AcctType parseAndValidateAccountType(String accountType) 
	{
		return AcctType.valueOf(accountType.toUpperCase());
	}
}
