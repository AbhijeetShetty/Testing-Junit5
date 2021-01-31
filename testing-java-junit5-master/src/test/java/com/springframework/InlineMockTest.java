package com.springframework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import java.util.Map;

public class InlineMockTest {

	@Test
	void testInlineMock() throws Exception {
		Map mapMock = mock(Map.class);
		assertEquals(mapMock.size(), 0);
	}
}
