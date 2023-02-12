package telran.time.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.measure.Length;
import telran.measure.LengthUnit;

class LengthTest {

	@Test
	void equalsTest() {	
		assertTrue(new Length(10, LengthUnit.M).equals(new Length(1000, LengthUnit.CM)));
		assertTrue(new Length(1_000_000_000, LengthUnit.MM).equals(new Length(1000, LengthUnit.KM)));
		assertFalse(new Length(1000, LengthUnit.M).equals(new Length(100, LengthUnit.IN)));
	}
	
	@Test
	void compareTest() {		
		assertEquals(0, new Length(10, LengthUnit.M).compareTo(new Length(1000, LengthUnit.CM)));
		assertEquals(-1, new Length(10, LengthUnit.M).compareTo(new Length(10000, LengthUnit.CM)));
		assertEquals(1, new Length(100, LengthUnit.M).compareTo(new Length(1000, LengthUnit.CM)));
	}
	
	@Test
	void convertTest() {		
		assertEquals(new Length(10, LengthUnit.M), (new Length(1000, LengthUnit.CM)).convert(LengthUnit.M));
		assertEquals(new Length(0.01f, LengthUnit.KM), (new Length(1000, LengthUnit.CM)).convert(LengthUnit.KM));
	}

	@Test
	void toStringTest() {		
		assertEquals("20.0M", (new Length(20, LengthUnit.M)).toString());
		assertEquals("20.5M", (new Length(20.5f, LengthUnit.M)).toString());
		assertEquals("20.56M", (new Length(20.56f, LengthUnit.M)).toString());
		assertEquals("20.5602M", (new Length(20.56020f, LengthUnit.M)).toString());
	}
	
	@Test
	void betweenTest() {
		assertEquals(new Length(1, LengthUnit.M), LengthUnit.M.between(new Length(200, LengthUnit.CM), new Length(1, LengthUnit.M)));
		assertEquals(new Length(1, LengthUnit.M), LengthUnit.M.between( new Length(1, LengthUnit.M), new Length(200, LengthUnit.CM)));
		
		assertEquals(new Length(2, LengthUnit.M), LengthUnit.M.between( new Length(1, LengthUnit.M), new Length(300, LengthUnit.CM)));
	}
}
