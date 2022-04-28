package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

class FinancingTests {

	@Test
	void constructorShouldCreateObjectWhenValidData() {
		// Arrange
		
		// Action
		Financing f = new Financing(100000.0, 2000.0, 80);
		
		// Assertions
		Assertions.assertEquals(100000.0, f.getTotalAmount());
		Assertions.assertEquals(2000.0, f.getIncome());
		Assertions.assertEquals(80, f.getMonths());
	}
	
	@Test
	void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		// Arrange
		
		// Action
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = new Financing(100000.0, 2000.0, 20);
		});
	}

}
