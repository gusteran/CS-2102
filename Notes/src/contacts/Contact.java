package contacts;


public class Contact {

	String name;
	PhoneNumber phone;
	String email;
	Address thisAddress;
}

class PhoneNumber {
	String areaCode;
	String number;
}


class Address {
	int num;
	String street;
	int zipcode;
	
	public int hashCode() {
		return (this.num * 3) + (this.street.hashCode() * 11) +
				(this.zipcode * 29);
	}
	
	public boolean equals(Object other) {
		Address thisAddr = (Address)other;
		
		return (this.num == thisAddr.num) && 
				(this.street.equals(thisAddr.street)) &&
				(this.zipcode == thisAddr.zipcode);
				
	}
	
}