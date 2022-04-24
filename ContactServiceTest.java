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

class ContactServiceTest {

	@Test
	void testAddContact() {
		ContactService contacts = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact(null, "valid", "valid", "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("valid", null, "valid", "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("valid", "valid", null, "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("valid", "valid", "valid", null, "valid"));
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("valid", "valid", "valid", "5555555555", null));
		
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("invalid_too_long", "valid", "valid", "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("valid", "invalid_too_long", "valid", "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("valid", "valid", "invalid_too_long", "5555555555", "valid"));
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("valid", "valid", "valid", "invalid_too_long", "valid"));
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("valid", "valid", "valid", "tooshort", "valid"));
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("valid", "valid", "valid", "5555555555", "invalid_too_long_has_to_be_even_longer"));
		
		assertDoesNotThrow(() -> contacts.addContact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address"));
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address"));
		assertDoesNotThrow(() -> contacts.addContact("valid_id2", "valid_fn", "valid_ln", "5555555555", "valid_address"));
	}

	@Test
	void testDeleteContact() {
		ContactService contacts = new ContactService();
		//deleteContact() doesn't throw if the id doesn't exist, so don't test for that.
		contacts.addContact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		
		//The following line is an arbitrary choice of code that confirms the id is indeed taken.
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address"));
		
		assertDoesNotThrow(() -> contacts.deleteContact("valid_id"));
		
		//And the following is an arbitrary choice to make sure the id was indeed freed.
		assertDoesNotThrow(() -> contacts.addContact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address"));
	}

	@Test
	void testUpdateFirstName() {
		ContactService contacts = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> contacts.updateFirstName("valid_id", "valid_fn"));
		contacts.addContact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		
		assertThrows(IllegalArgumentException.class, () -> contacts.updateFirstName("valid_id", null));
		assertThrows(IllegalArgumentException.class, () -> contacts.updateFirstName("valid_id", "invalid_too_long"));
		assertDoesNotThrow(() -> contacts.updateFirstName("valid_id", "valid_fn2"));
	}

	@Test
	void testUpdateLastName() {
		ContactService contacts = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> contacts.updateLastName("valid_id", "valid_ln"));
		contacts.addContact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		
		assertThrows(IllegalArgumentException.class, () -> contacts.updateLastName("valid_id", null));
		assertThrows(IllegalArgumentException.class, () -> contacts.updateLastName("valid_id", "invalid_too_long"));
		assertDoesNotThrow(() -> contacts.updateLastName("valid_id", "valid_ln2"));
	}

	@Test
	void testUpdatePhone() {
		ContactService contacts = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> contacts.updatePhone("valid_id", "5555555555"));
		contacts.addContact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		
		assertThrows(IllegalArgumentException.class, () -> contacts.updatePhone("valid_id", null));
		assertThrows(IllegalArgumentException.class, () -> contacts.updatePhone("valid_id", "invalid_too_long"));
		assertThrows(IllegalArgumentException.class, () -> contacts.updatePhone("valid_id", "tooshort"));
		assertDoesNotThrow(() -> contacts.updatePhone("valid_id", "5555555556"));
	}

	@Test
	void testUpdateAddress() {
		ContactService contacts = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> contacts.updateAddress("valid_id", "valid_address"));
		contacts.addContact("valid_id", "valid_fn", "valid_ln", "5555555555", "valid_address");
		
		assertThrows(IllegalArgumentException.class, () -> contacts.updateAddress("valid_id", null));
		assertThrows(IllegalArgumentException.class, () -> contacts.updateAddress("valid_id", "invalid_too_long_has_to_be_even_longer"));
		assertDoesNotThrow(() -> contacts.updateAddress("valid_id", "valid_address2"));
	}

}
