package bank;


public class CustomerNotFoundException extends Exception {

	private String unfoundName;
	
	CustomerNotFoundException(String unfoundName) {
		this.unfoundName = unfoundName;
	}
	
	public String getUnfoundName() {
		return this.unfoundName;
	}
	
}
