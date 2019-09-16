package bank;

import java.util.LinkedList;

public class AcctLinkedList implements IAcctDataStructure {

	private LinkedList<Account> accounts;
	
	public Account findByNumber(int acctNum) {
	    for (Account acct: accounts) {
	        if (acct.checkNumber(acctNum))
	          return acct;
	      }
	    
	    return null;
	}
}
