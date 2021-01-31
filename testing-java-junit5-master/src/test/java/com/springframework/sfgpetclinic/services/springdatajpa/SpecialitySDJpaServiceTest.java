package com.springframework.sfgpetclinic.services.springdatajpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import java.util.Optional;

import com.springframework.sfgpetclinic.model.Speciality;
import com.springframework.sfgpetclinic.repositories.SpecialtyRepository;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

	@Mock
	SpecialtyRepository specialtyRepository;

	@InjectMocks
	SpecialitySDJpaService service;

	@Test
	void testfindByID() {
		Speciality speciality = new Speciality();
		when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));
		Speciality foundSpeciality = service.findById(1L);
		assertThat(foundSpeciality).isNotNull();
		verify(specialtyRepository).findById(1L);
	}

	@Test
	void testFindByIdBdd() {
		// given
		Speciality speciality = new Speciality();
		given(specialtyRepository.findById(1L)).willReturn(Optional.of(speciality));

		// when
		Speciality foundSpecialty = service.findById(1L);

		// then
		assertThat(foundSpecialty).isNotNull();
		then(specialtyRepository).should().findById(anyLong());
		then(specialtyRepository).shouldHaveNoMoreInteractions();
	}

	@Test
	void testDeleteByObject() {
		Speciality speciality = new Speciality();
		service.delete(speciality);
		verify(specialtyRepository).delete(any(Speciality.class));
	}

	@Test
	void testDeleteByObjectBdd() {
		//given
		Speciality speciality = new Speciality();
		//when
		service.delete(speciality);
		//then
		then(specialtyRepository).should().delete(any(Speciality.class));
	}
	@Test
	void deleteById() {
		service.deleteById(1l);
		service.deleteById(1l);
		verify(specialtyRepository, times(2)).deleteById(1l);
	}
	
	@Test
	void deleteByIdBdd() {
		//given -none

		//when
		service.deleteById(1l);
		service.deleteById(1l);

		//then
		then(specialtyRepository).should(times(2)).deleteById(1L);
	}

	
	@Test
	void deleteByIdAtLeast() {
		service.deleteById(1l);
		service.deleteById(1l);

		verify(specialtyRepository, atLeastOnce()).deleteById(1l);
	}
	
	@Test
	void deleteByIdAtLeastBdd() {
		//given -none

		//when
		service.deleteById(1l);
		service.deleteById(1l);
		//then
		then(specialtyRepository).should(atLeastOnce()).deleteById(1l);
	}

	@Test
	void deleteByIdAtMost() {
		service.deleteById(1l);
		service.deleteById(1l);

		verify(specialtyRepository, atMost(5)).deleteById(1l);
	}

	
	@Test
	void deleteByIdAtMostBdd() {
		//given - none
		
		//when
		service.deleteById(1l);
		service.deleteById(1l);
		
		//then
		then(specialtyRepository).should(atMost(5)).deleteById(1l);
	}
	@Test
	void deleteByIdNever() {
		service.deleteById(1l);
		service.deleteById(1l);
		verify(specialtyRepository,atLeastOnce()).deleteById(1l);
		verify(specialtyRepository,never()).deleteById(5L);
	}
	
	@Test
	void deleteByIdNeverBdd() {
		//given - none
		
		//when
		service.deleteById(1l);
		service.deleteById(1l);
		
		//then
		then(specialtyRepository).should(atLeastOnce()).deleteById(1l);
		then(specialtyRepository).should(never()).deleteById(5L);
	}

	@Test
	void testDelete() {
		service.delete(new Speciality());
	}
	
	@Test
	void testDeleteBdd() {
		//given - none
		
		//when
		service.delete(new Speciality());
		
		//then
		then(specialtyRepository).should().delete(any());
	}
}
