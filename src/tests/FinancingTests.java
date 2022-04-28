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
	
	@Test
	void setTotalAmountShouldUpdateObjectWhenValidData() {
		// Arrange
		Financing f = new Financing(100000.0, 2000.0, 80);
		
		// Action
		f.setTotalAmount(90000.00);
		
		// Assertions
		Assertions.assertEquals(90000.0, f.getTotalAmount());		
	}
	
	@Test
	void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		// Arrange
		Financing f = new Financing(100000.0, 2000.0, 80);
		
		// Action
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Action
			f.setTotalAmount(190000.00);
		});
	}
	
	@Test
	void setIncomeShouldUpdateObjectWhenValidData() {
		// Arrange
		Financing f = new Financing(100000.0, 2000.0, 80);
		
		// Action
		f.setIncome(2001.00);
		
		// Assertions
		Assertions.assertEquals(2001.0, f.getIncome());		
	}
	
	@Test
	void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		// Arrange
		Financing f = new Financing(100000.0, 2000.0, 80);
		
		// Assertion
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Action
			f.setIncome(1900.00);
		});
	}
	
	@Test
	void setMonthsShouldUpdateObjectWhenValidData() {
		// Arrange
		Financing f = new Financing(100000.0, 2000.0, 80);
		
		// Action
		f.setMonths(81);
		
		// Assertions
		Assertions.assertEquals(81, f.getMonths());		
	}
	
	@Test
	void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		// Arrange
		Financing f = new Financing(100000.0, 2000.0, 80);
		
		// Assertion
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Action
			f.setMonths(70);
		});
	}
	
	@Test
	void entryShouldCalculateEntryCorrectly() {
		// Arrange
		Financing f = new Financing(100000.0, 2000.0, 80);
		
		// Action
				
		// Assertions
		Assertions.assertEquals(20000.00, f.entry());
	}
	

}
