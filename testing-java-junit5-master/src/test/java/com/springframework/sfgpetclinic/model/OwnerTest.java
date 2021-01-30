package com.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.springframework.sfgpetclinic.ModelTest;


class OwnerTest implements ModelTest{

	@Test
	void dependentAssertion() {
		Owner owner = new Owner(1L, "Joe", "Buck");
		owner.setCity("New York");
		owner.setTelephone("1234567890");

		assertAll("Properties Test",
				() -> assertAll("Person Properties",
						() -> assertEquals("Joe", owner.getFirstName(), "first name did not match"),
						() -> assertEquals("Buck", owner.getLastName(), "last name did not match")),
				() -> assertAll("Owner Properties",
						() -> assertEquals("New York", owner.getCity(), "City did not match"),
						() -> assertEquals("1234567890", owner.getTelephone(), "Phone Number did not match"))
				);

	}

}
