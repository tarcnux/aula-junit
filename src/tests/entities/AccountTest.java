package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

class AccountTest {

	@Test
	void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		
		// Arrange
		double amount = 200.0;
		double expectedValue = 196.00;
		
		Account acc = AccountFactory.createEmptyAccount();
		
		// Act
		acc.deposit(amount);
		
		// Assertions
		Assertions.assertEquals(expectedValue, acc.getBalance());		
	}
	
	@Test
	void depositShouldDoNothingWhenNegativeAmount() {
		// Arrange
		double amount = -200.0;
		double expectedValue = 100.0;
		
		Account acc = AccountFactory.createAccount(expectedValue);
		
		// Act
		acc.deposit(amount);
		
		// Assertions
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
}