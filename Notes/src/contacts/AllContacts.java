package contacts;

import java.util.HashMap;
import java.util.LinkedList;

public class AllContacts {

	HashMap<Address, LinkedList<Contact>> contacts =
			new HashMap<Address, LinkedList<Contact>>();
	
	public LinkedList<Contact> getContact(Address key) {
		return this.contacts.get(key);
	}
	
	public void addContact(Address key, Contact aContact) {
		LinkedList<Contact> contact = this.contacts.get(key);
		
		contact.add(aContact);
		
		contacts.put(key, contact);
	}
}
