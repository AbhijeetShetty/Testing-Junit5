package com.springframework.sfgpetclinic.controllers;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

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
	
		assertThat(controller.index()).isEqualTo("index");
		}

	@DisplayName("Test exception")
	@Test
	void testOupsHandler() {
		assertThrows(ValueNotFoundException.class, () -> controller.oopsHandler());
	}

	@Disabled("Demo of Timeout")
	@Test
	void testTimeOut(){		
		assertTimeout(Duration.ofMillis(100),()->{
			Thread.sleep(5000);
			System.out.println("I am here");
		} );		
	}
	
	@Disabled("Demo of TimeOutPrempt")
	@Test
	void testTimeOutPrempt(){		
		assertTimeoutPreemptively(Duration.ofMillis(100),()->{
			Thread.sleep(5000);
			System.out.println("I am in preemptive test");
		} );		
	}
	
	@EnabledOnOs(OS.WINDOWS)
	@Test
	void testMeOnWin() {
		
	}
	
	@EnabledOnOs(OS.MAC)
	@Test
	void testMeOnMac() {
		
	}
	@EnabledOnJre(JRE.JAVA_8)
	@Test
	void testMeOnJava8() {
		
	}
	
	@EnabledOnJre(JRE.JAVA_11)
	@Test
	void testMeOnJava11() {
		
	}
	
	@EnabledIfEnvironmentVariable(named="USERNAME",matches ="AS")
	@Test
	void testMeIfUserAS(){
		
	}
}
