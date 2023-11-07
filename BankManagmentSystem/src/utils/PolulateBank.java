package utils;
import java.time.LocalDate;
import java.util.HashMap;

import com.bank.AcctType;
import com.bank.BankAccount;
import custom_exception.BankingException;

import  static utils.ValidateAllInputs.validateAllInputs;

public class PolulateBank 
{
	
	public static HashMap<Long, BankAccount> populateBank() throws BankingException
	{
		HashMap<Long, BankAccount> hm=new HashMap<>();
		
		hm.put(20231110001L, validateAllInputs(20231110001L, "Balaji", "saving", 10000, "07/11/2023", hm));
		hm.put(20231110005L, validateAllInputs(20231110005L, "Sachin", "saving", 60000, "11/11/2023", hm));
		hm.put(20231110003L, validateAllInputs(20231110003L, "Akash", "saving", 70000, "10/12/2022", hm));
		hm.put(20231110002L, validateAllInputs(20231110002L, "Ganesh", "saving", 30000, "03/02/2022", hm));
		hm.put(20231110004L, validateAllInputs(20231110004L, "Yogesh", "saving", 40000, "09/10/2021", hm));
	
		return hm;
	}
	
}
