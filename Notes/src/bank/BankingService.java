package bank;
import java.util.LinkedList;

class Customer {
  private String name;   
  private int password;  
  private LinkedList<Account> accounts; 
  
  public boolean checkName(String name) {
	  return this.name.equals(name);
  }
  
  public boolean checkPassword(int passsword) {
	  return this.password == password;
  }
  
  public String getName() {
	  return name;
  }

  
}


class Account {
  private int number;      
  private Customer owner;  
  private double balance;
  
  public Account() {
	  
  }
  
  public boolean checkNumber(int number) {
	  return this.number == number;
  }
  
  public double getBalance() {
	  return this.balance;
  }
  
  
   public void withdraw(double amt) {
	   this.balance = this.balance - amt;
   }
  
}

class BankingService {
  private IAcctDataStructure accounts;   
  private ICustDataStructure customers; 
  
  double getBalance(int forAcctNum) { 
	Account myAccount = accounts.findByNumber(forAcctNum);
	return myAccount.getBalance();
  }
  
  double withdraw(int forAcctNum, double amt) {  
	Account myAccount = accounts.findByNumber(forAcctNum);
	myAccount.withdraw(amt);
	return amt;
  }
  
  String login(String custname, int withPwd) {
	Customer cust = customers.findCustomerByNameAndPassword(custname, withPwd);
	return "Welcome";

  }
    
}