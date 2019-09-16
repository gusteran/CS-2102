package bank;


public interface ICustDataStructure {

	public Customer findCustomerByNameAndPassword(String name, int pwd) throws CustomerNotFoundException, LoginFailedException;
	public void addCust(Customer cust);
	
}
