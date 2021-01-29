package com.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {
 
	@Test
	void groupedAssertions() {

		// given
		Person person = new Person(1L, "Joe", "Buck");

		// then
		assertAll("Test Props Set", 
				() -> assertEquals("Joe", person.getFirstName(), "First Name failed"),
				() -> assertEquals("Buck", person.getLastName(), "Second Name failed"));
	}

}
