package com.test;


import static utils.PolulateBank.populateBank;
import static utils.ValidateAllInputs.validateAllInputs;
import static utils.ValidateAllInputs.parseAndValidateAccountType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.bank.AcctType;
import com.bank.BankAccount;
import custom_exception.BankingException;

public class TestBanking 
{
	public static void main(String[] args) 
	{
		try(Scanner sc=new Scanner(System.in);)
		{
			HashMap<Long, BankAccount> bankMap=new HashMap<>();
			
			try
			{
				bankMap=populateBank();
				
				int choice=0;
				do
				{
					System.out.println("\n *** Welcome  ***\n");
					System.out.println("1. Display all customers");
					System.out.println("2. Create Account");
					System.out.println("3. Get Account Details");
					System.out.println("4. Deposit Amount");
					System.out.println("5. Withdrow Amount");
					System.out.println("6. Transfer Amount");
					System.out.println("7. Close(Delete) Account");
					System.out.println("8. Get All Account Numbers only");
					System.out.println("9. Converting Map Into Collection");
					System.out.println("10. display name of all customers in Saving AccountType ");
					
					System.out.println("0. Exist");
					
					System.out.println("\nEnter your Choice: ");
					choice=sc.nextInt();
					
					switch(choice)
					{
					
					case 1:   
						bankMap.entrySet().forEach(cust->System.out.println(cust));
						break;
						
					case 2:    // acctNo, CustName, type, balance, created, hm//
						System.out.println("Enter account details: AccountNo, CustName, accountType, balance, creaderDate(dd/MM/yyyy)");
						long accNo=sc.nextLong();
						String custName=sc.next();
						String accountType=sc.next();
						double bal=sc.nextDouble();
						String date=sc.next();
						
						bankMap.put(accNo, validateAllInputs(accNo, custName, accountType, bal, date, bankMap));
						System.out.println("Account created Successfully...!!!!");
						
						break;
					
					case 3:
						System.out.println("Enter Account No:");
						accNo=sc.nextLong();
						BankAccount account=bankMap.get(accNo); // Auto boxing long >> Long i.e Primitive to Reference type
						
						if(account!=null)
						{
							if(account.isActive())
								System.out.println(account);
						}
						else 
							throw new BankingException("Invalid Account No...!!!!");
						
						break;
						
					case 4:
						System.out.println("Enter AccountNo on which you want to deposit ammount: ");
						accNo=sc.nextLong();
						account=bankMap.get(accNo);
						if(account==null)
							throw new BankingException("Invalid Account No...!!!!");
						
						System.out.println("Enter amount to deposit: ");
						double amount=sc.nextDouble();
						account.deposit(amount);
						System.out.println("amount deposited successfully...!!!");
						
						break;
					
					case 5:
						System.out.println("Enter AccountNo from which you want to withdraw amount: ");
						accNo=sc.nextLong();
						account=bankMap.get(accNo);
						if(account==null)
							throw new BankingException("Invalid Account No...!!!!");
						
						System.out.println("Enter amount for withdraw: ");
						amount=sc.nextDouble();
						account.withdraw(amount);;
						System.out.println("amount withdraw successfully...!!!");
						
						break;
						
					case 6:
						System.out.println("Enter sourse AccountNO: ");
						BankAccount src=bankMap.get(sc.nextLong()); //Auto Boxing long >> Long
						if(src==null)
							throw new BankingException("Invalid sourse AccountNo...!!!");
						
						System.out.println("Enter destination AccountNO: ");
						BankAccount dest=bankMap.get(sc.nextLong());  // AutoBoxing long >> Long
						if(dest==null)
							throw new BankingException("Invalid destination AccountNo...!!!");
						
						System.out.println("enter Amount to transfer: ");
						amount=sc.nextDouble();
						
						src.fundTransfer(dest, amount);
						System.out.println("fund transfer successfully...!!!");
						
						break;
						
					case 7:
						System.out.println("Enter AccountNo you want to close: ");
						account=bankMap.remove(sc.nextLong());
						if(account==null)
							throw new BankingException("Invalid AccountNo, can not close account...!!!");
						
						System.out.println("closed:: "+account);
						
						break;
					
					case 8:
						Set<Long> keys=bankMap.keySet();
						//Using lambda Expression
						keys.forEach(k->System.out.println(k));
						
						//Using ForEach Loop
//						for(Long L:keys)
//							System.out.println(L);
						
						break;
						
					case 9:
						Collection<BankAccount> colls=bankMap.values();
						//Using lambda Expression
						colls.forEach(c->System.out.println(c));
						
						//Using forEach loop
//						for(BankAccount act:colls)
//							System.out.println(act);
						
						break;
		
					case 10:
						
						System.out.println("Enter accountType from which you wants all names: ");
						String actType=sc.next();
						
						AcctType acountType=parseAndValidateAccountType(actType);
						
						//limitation in Map : only key based searching in Map api
						//soln : convert Map --> Collection<V> : values
						
						Collection<BankAccount> listColls=bankMap.values();
						for(BankAccount act:listColls)
						{
							if(act.getType()==acountType)
								System.out.println(act.getCustomerName());
						}
						
						
						break;
						
						
					case 0:
						System.out.println("Thank you Visit Again....!!!");
						break;
						
					} // switch case end.
					
				}while(choice!=0);	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		} 
	}
}
