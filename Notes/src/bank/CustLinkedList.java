package bank;
import java.util.LinkedList;

public class CustLinkedList implements ICustDataStructure {
	
	private LinkedList<Customer> customers;
	
	public Customer findCustomerByNameAndPassword(String name, int pwd) {
		for (Customer cust:customers) {    
			if (cust.checkName(name)) {     
		        if (cust.checkPassword(pwd))  
		          return cust;
		      }
	}
		
		return null;
	}

}
