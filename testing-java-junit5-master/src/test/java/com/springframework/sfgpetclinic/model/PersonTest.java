package com.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.springframework.sfgpetclinic.ModelTest;


class PersonTest implements ModelTest{
  
	@Test
	void groupedAssertions() {

		// given
		Person person = new Person(1L, "Joe", "Buck");

		// then
		assertAll("Test Props Set", 
				() -> assertEquals("Joe", person.getFirstName(), "First Name failed"),
				() -> assertEquals("Buck", person.getLastName(), "Second Name failed"));
	}
	
	@RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions} ")
	@DisplayName("My test repeated")
	@Test
	void testRepeated() {
		
	}
 
}
