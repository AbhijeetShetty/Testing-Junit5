package com.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.springframework.sfgpetclinic.CustomArgsProvider;
import com.springframework.sfgpetclinic.ModelTest;

class OwnerTest implements ModelTest {

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
						() -> assertEquals("1234567890", owner.getTelephone(), "Phone Number did not match")));

	}

	@DisplayName("Value source test")
	@ParameterizedTest(name = "[{index}]-{arguments}")
	@ValueSource(strings = { "This", "is", "a", "list", "of", "string", "for", "testing" })
	void testValueSource(String val) {
		System.out.println(val);
	}

	@DisplayName("Enum Source Test")
	@ParameterizedTest(name = "[{index}]-{arguments}")
	@EnumSource(OwnerType.class)
	void enumTest(OwnerType ownerType) {
		System.out.println(ownerType);
	}

	@DisplayName("CSV Input Test")
	@ParameterizedTest(name = "[{index}] {arguments}")
	@CsvSource({ "FL, 1, 1", "OH, 2, 2", "MI, 3, 1" })
	void csvInputTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}

	@DisplayName("Method Provider Test")
	@ParameterizedTest(name = "[{index}] {arguments}")
	@MethodSource("getargs")
	void fromMethodTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}

	static Stream<Arguments> getargs() {
		return Stream.of(Arguments.of("FL", 5, 1), Arguments.of("OH", 2, 8), Arguments.of("MI", 3, 5));
	}

	@DisplayName("Custom Provider Test")
	@ParameterizedTest(name = "[{index}] {arguments}")
	@ArgumentsSource(CustomArgsProvider.class)
	void fromCustomProviderTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}
}
