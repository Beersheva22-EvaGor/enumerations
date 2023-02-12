package telran.time.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.time.DayOfWeek;

class DayOfWeekTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void valuesTest() {
		DayOfWeek[] array = DayOfWeek.values();
		assertEquals(DayOfWeek.SUN, array[0]);
		assertEquals(7, array.length);
	}

}
