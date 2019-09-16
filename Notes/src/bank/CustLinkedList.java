package bank;

import java.util.LinkedList;

public class CustLinkedList implements ICustDataStructure {
	
	private LinkedList<Customer> customers;
	
	public CustLinkedList() {
		customers = new LinkedList<Customer>();
	}
	
	public void addCust(Customer cust) {
		customers.add(cust);
	}
	
	public Customer findCustomerByNameAndPassword(String name, int pwd) throws CustomerNotFoundException, LoginFailedException {
		Customer cust = this.findCustomerByName(name);
		this.findCustomerPassword(cust, pwd);
		return cust;
		
	}
	
	public Customer findCustomerByName(String name) throws CustomerNotFoundException {
		for (Customer cust:customers) {    
			if (cust.checkName(name)) {     
					return cust;
		      }
		}
		
		throw new CustomerNotFoundException(name);
	}
	
	public boolean findCustomerPassword(Customer cust, int password) throws LoginFailedException {
		boolean passwordExists = cust.checkPassword(password);
		
		if(!passwordExists) throw new LoginFailedException();
		else return passwordExists;
	}

}
