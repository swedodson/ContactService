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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContact() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(null, "valid", "valid", "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("valid", null, "valid", "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("valid", "valid", null, "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("valid", "valid", "valid", null, "valid"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("valid", "valid", "valid", "5555555555", null));
		
		assertThrows(IllegalArgumentException.class, () -> new Contact("invalid_too_long", "valid", "valid", "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("valid", "invalid_too_long", "valid", "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("valid", "valid", "invalid_too_long", "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("valid", "valid", "valid", "invalid_too_long", "valid"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("valid", "valid", "valid", "tooshort", "valid"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("valid", "valid", "valid", "5555555555", "invalid_too_long_has_to_be_even_longer"));
		
		assertDoesNotThrow(() -> new Contact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address"));
	}

	@Test
	void testGetId() {
		Contact contact = new Contact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		assertEquals(contact.getId(), "valid_id");
	}

	@Test
	void testGetFirstName() {
		Contact contact = new Contact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		assertEquals(contact.getFirstName(), "valid_fn");
	}

	@Test
	void testSetFirstName() {
		Contact contact = new Contact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
		assertEquals(contact.getFirstName(), "valid_fn");
		
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("invalid_too_long"));
		assertEquals(contact.getFirstName(), "valid_fn");
		
		assertDoesNotThrow(() -> contact.setFirstName("valid_fn2"));
		assertEquals(contact.getFirstName(), "valid_fn2");
	}

	@Test
	void testGetLastName() {
		Contact contact = new Contact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		assertEquals(contact.getLastName(), "valid_ln");
	}

	@Test
	void testSetLastName() {
		Contact contact = new Contact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
		assertEquals(contact.getLastName(), "valid_ln");
		
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName("invalid_too_long"));
		assertEquals(contact.getLastName(), "valid_ln");
		
		assertDoesNotThrow(() -> contact.setLastName("valid_ln2"));
		assertEquals(contact.getLastName(), "valid_ln2");
	}

	@Test
	void testGetPhone() {
		Contact contact = new Contact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		assertEquals(contact.getPhone(), "5555555555");
	}

	@Test
	void testSetPhone() {
		Contact contact = new Contact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
		assertEquals(contact.getPhone(), "5555555555");
		
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("invalid_too_long"));
		assertEquals(contact.getPhone(), "5555555555");
		
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("tooshort"));
		assertEquals(contact.getPhone(), "5555555555");
		
		assertDoesNotThrow(() -> contact.setPhone("5555555556"));
		assertEquals(contact.getPhone(), "5555555556");
	}

	@Test
	void testGetAddress() {
		Contact contact = new Contact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		assertEquals(contact.getAddress(), "valid_address");
	}

	@Test
	void testSetAddress() {
		Contact contact = new Contact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
		assertEquals(contact.getAddress(), "valid_address");
		
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress("invalid_too_long_has_to_be_even_longer"));
		assertEquals(contact.getAddress(), "valid_address");
		
		assertDoesNotThrow(() -> contact.setAddress("valid_address2"));
		assertEquals(contact.getAddress(), "valid_address2");
	}

}
