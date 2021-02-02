package com.springframework.sfgpetclinic.services.springdatajpa;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

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
		// given
		Speciality speciality = new Speciality();
		// when
		service.delete(speciality);
		// then
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
		// given -none

		// when
		service.deleteById(1l);
		service.deleteById(1l);

		// then
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
		// given -none

		// when
		service.deleteById(1l);
		service.deleteById(1l);
		// then
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
		// given - none

		// when
		service.deleteById(1l);
		service.deleteById(1l);

		// then
		then(specialtyRepository).should(atMost(5)).deleteById(1l);
	}

	@Test
	void deleteByIdNever() {
		service.deleteById(1l);
		service.deleteById(1l);
		verify(specialtyRepository, atLeastOnce()).deleteById(1l);
		verify(specialtyRepository, never()).deleteById(5L);
	}

	@Test
	void deleteByIdNeverBdd() {
		// given - none

		// when
		service.deleteById(1l);
		service.deleteById(1l);

		// then
		then(specialtyRepository).should(atLeastOnce()).deleteById(1l);
		then(specialtyRepository).should(never()).deleteById(5L);
	}

	@Test
	void testDelete() {
		service.delete(new Speciality());
	}

	@Test
	void testDeleteBdd() {
		// given - none

		// when
		service.delete(new Speciality());

		// then
		then(specialtyRepository).should().delete(any());
	}

	@Test
	void testDoThrow() {
		doThrow(new RuntimeException("Run time exception")).when(specialtyRepository).delete(any());
		assertThrows(RuntimeException.class, () -> specialtyRepository.delete(new Speciality()));
		verify(specialtyRepository).delete(any());
	}

	@Test
	void testFindByIdThrows() {
		given(specialtyRepository.findById(1L)).willThrow(new RuntimeException("boom"));

		assertThrows(RuntimeException.class, () -> service.findById(1L));

		then(specialtyRepository).should().findById(1L);
	}

	@Test
	void testDeleteBDD() {
		willThrow(new RuntimeException("boom")).given(specialtyRepository).delete(any());

		assertThrows(RuntimeException.class, () -> specialtyRepository.delete(new Speciality()));

		then(specialtyRepository).should().delete(any());
	}

	@Test
	void testSaveLambda() {
		// given
		final String MATCH_ME = "MATCH_ME";
		Speciality speciality = new Speciality();
		speciality.setDescription(MATCH_ME);

		Speciality savedSpecialty = new Speciality();
		savedSpecialty.setId(1L);

		// need mock to only return on match MATCH_ME string
		given(specialtyRepository.save(argThat(argument -> argument.getDescription().equals(MATCH_ME))))
				.willReturn(savedSpecialty);

		// when
		Speciality returnedSpecialty = service.save(speciality);

		// then
		assertThat(returnedSpecialty.getId()).isEqualTo(1L);
	}

	@Disabled
	@Test
	void testSaveLambdaNoMatch() {
		// given
		final String MATCH_ME = "MATCH_ME";
		Speciality speciality = new Speciality();
		speciality.setDescription("Not a match");

		Speciality savedSpecialty = new Speciality();
		savedSpecialty.setId(1L);

		// need mock to only return on match MATCH_ME string
		given(specialtyRepository.save(argThat(argument -> argument.getDescription().equals(MATCH_ME))))
				.willReturn(savedSpecialty);

		// when
		Speciality returnedSpecialty = service.save(speciality);

		// then
		assertNull(returnedSpecialty);
	}
}
