package com.springframework.sfgpetclinic.services.springdatajpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.then;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springframework.sfgpetclinic.model.Visit;
import com.springframework.sfgpetclinic.repositories.VisitRepository;



@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

	@Mock
	VisitRepository visitRepository;

	@InjectMocks
	VisitSDJpaService service;

	@Test
	void testFindAll() {
		Visit visit = new Visit();

		Set<Visit> visits = new HashSet<>();
		visits.add(visit);

		when(visitRepository.findAll()).thenReturn(visits);

		Set<Visit> foundVisits = service.findAll();

		verify(visitRepository).findAll();

		assertThat(foundVisits).hasSize(1);
	}

	@Test
	void testFindAllBdd() {

		// given
		Visit visit = new Visit();
		Set<Visit> visits = new HashSet<>();
		visits.add(visit);
		given(visitRepository.findAll()).willReturn(visits);

		//when
		Set<Visit> foundVisits = service.findAll();

		//then
		then(visitRepository).should().findAll();
		assertThat(foundVisits).hasSize(1);
	}

	@Test
	void testFindById() {
		Visit visit = new Visit();

		when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));

		Visit foundVisit = service.findById(1L);

		verify(visitRepository).findById(anyLong());

		assertThat(foundVisit).isNotNull();
	}
	
	@Test
	void testFindByIdBdd() {
		//given
		Visit visit = new Visit();
		given(visitRepository.findById(anyLong())).willReturn(Optional.of(visit));

		//when
		Visit foundVisit = service.findById(1L);

		//then
		then(visitRepository).should().findById(anyLong());
		assertThat(foundVisit).isNotNull();
	}

	@Test
	void testSave() {
		Visit visit = new Visit();

		when(visitRepository.save(any(Visit.class))).thenReturn(visit);

		Visit savedVisit = service.save(new Visit());

		verify(visitRepository).save(any(Visit.class));

		assertThat(savedVisit).isNotNull();
	}
	
	void testSaveBdd() {
		//given
		Visit visit = new Visit();
		given(visitRepository.save(any(Visit.class))).willReturn(visit);

		//when
		Visit savedVisit = service.save(new Visit());
		
		//then
		then(visitRepository).should().save(any(Visit.class));
		assertThat(savedVisit).isNotNull();
	}

	@Test
	void testDelete() {
		Visit visit = new Visit();

		service.delete(visit);

		verify(visitRepository).delete(any(Visit.class));
	}
	
	@Test
	void testDeleteBdd() {
		//given
		Visit visit = new Visit();

		//when
		service.delete(visit);

		//then
		then(visitRepository).should().delete(any(Visit.class));
	}

	@Test
	void testDeleteById() {
		service.deleteById(1L);

		verify(visitRepository).deleteById(anyLong());
	}
	
	@Test
	void testDeleteByIdBdd() {
		//when
		service.deleteById(1L);
		//then
		then(visitRepository).should().deleteById(anyLong());
	}

}
