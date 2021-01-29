package com.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.springframework.sfgpetclinic.exceptions.ValueNotFoundException;

class IndexControllerTest {

	IndexController controller;

	@BeforeEach
	void setUp() {
		controller = new IndexController();
	}

	@DisplayName("Test proper view name is returned for index page")
	@Test
	void testIndex() {
		assertEquals("index", controller.index());
		assertEquals("index", controller.index(), "Wrong view returned");
		assertEquals("index", controller.index(), () -> "Another expensive message, displayed only in case of failure");
	}

	@DisplayName("Test exception")
	@Test
	void testOupsHandler() {
		assertThrows(ValueNotFoundException.class, 
				() -> controller.oopsHandler());
	}

}
