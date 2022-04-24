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

public class Contact {
	private final String id; //final makes this inherently not able to be updated.
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		if(id == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		if(id.length() > 10) {
			throw new IllegalArgumentException("id cannot be longer than ten characters");
		}
		this.id = id;
		
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	
 
	public String getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName == null) {
			throw new IllegalArgumentException("firstName cannot be null");
		}
		if(firstName.length() > 10) {
			throw new IllegalArgumentException("firstName cannot be longer than ten characters");
		}
		
		this.firstName = firstName;
	}
	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName == null) {
			throw new IllegalArgumentException("lastName cannot be null");
		}
		if(lastName.length() > 10) {
			throw new IllegalArgumentException("lastName cannot be longer than ten characters");
		}
		
		this.lastName = lastName;
	}
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if(phone == null) {
			throw new IllegalArgumentException("phone cannot be null");
		}
		if(phone.length() != 10) {
			throw new IllegalArgumentException("phone must be exactly ten characters");
		}
		
		this.phone = phone;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(address == null) {
			throw new IllegalArgumentException("address cannot be null");
		}
		if(address.length() > 30) {
			throw new IllegalArgumentException("address cannot be longer than 30 characters");
		}
		
		this.address = address;
	} 
}
