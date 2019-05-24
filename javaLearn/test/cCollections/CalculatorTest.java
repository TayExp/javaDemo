package cCollections;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testCalculate() {
		assertEquals(3, new Calculator().calculate(" 1 +2"));
	}

}
