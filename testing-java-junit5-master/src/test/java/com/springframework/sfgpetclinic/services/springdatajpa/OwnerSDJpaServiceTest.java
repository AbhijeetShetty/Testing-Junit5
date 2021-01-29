package com.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.springframework.sfgpetclinic.model.Owner;

@Disabled(value="until mocking")
class OwnerSDJpaServiceTest {
	OwnerSDJpaService service;
	
	@BeforeEach
	void setUp() {
		service = new OwnerSDJpaService(null,null,null);
	} 

	@Disabled
	@Test
	void testOwnerSDJpaService() {
		Owner foundOwern = service.findByLastName("Buck");
	}

	@Test
	void testFindByLastName() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllByLastNameLike() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

}
