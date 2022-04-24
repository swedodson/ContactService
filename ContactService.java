//Title: CS 320 Project One
//Author: Clay Dodson
//Date: 04/10/2022
//References:
 	//Online resource - https://www.tutorialspoint.com/junit/junit_test_framework.htm
	//Online resource - https://stackoverflow.com/questions/70818397/what-needs-to-be-updated-to-make-the-junit5-test-successful
 	//SNHU Tutorial   - https://www.youtube.com/watch?v=KbXhK9HUng4
 	//Course Textbook - Garcia Boni. (2017). In Mastering software testing with JUnit 5: Comprehensive guide to develop high quality Java applications (pp. 83–136). essay, Packt Publishing. 
 	//Online resource - https://github.com/rowland007/Grand-Strand-Systems/tree/develop/src
	//Online resource - https://www.codejava.net/testing/junit-tutorial-for-beginner-with-eclipse

package contact;

import java.util.HashMap;

public class ContactService {
	private HashMap<String, Contact> contacts = new HashMap<String, Contact>();
	
	//Helper function to reduce boilerplate
	private Contact getContact(String id) {
		Contact contact = contacts.get(id);
		if(contact == null) {
			throw new IllegalArgumentException("No contact found with id " + id);
		}
		return contact;
	}
	
	public void addContact(String id, String firstName, String lastName, String phone, String address) {
		if(contacts.containsKey(id)) {
			throw new IllegalArgumentException("id " + id + " already in use");
		}
		contacts.put(id, new Contact(id, firstName, lastName, phone, address));
	}
	
	public void deleteContact(String id) {
		contacts.remove(id);
	}
	
	public void updateFirstName(String id, String firstName) {
		getContact(id).setFirstName(firstName);
	}
	
	public void updateLastName(String id, String lastName) {
		getContact(id).setLastName(lastName);
	}
	
	public void updatePhone(String id, String phone) {
		getContact(id).setPhone(phone);
	}
	
	public void updateAddress(String id, String address) {
		getContact(id).setAddress(address);
	}
}
