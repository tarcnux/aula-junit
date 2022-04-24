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
	
	@Test
	void fullWithdrawShoulClearBalance() {
		// Arrange
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		
		Account acc = AccountFactory.createAccount(initialBalance);
		
		// Act
		double result = acc.fullWithdraw();
		
		// Assertions
		Assertions.assertEquals(expectedValue, acc.getBalance());
		Assertions.assertTrue(result == initialBalance);		
	}
	
	@Test
	void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		// Arrange
		double expectedValue = 300.0;
		double amount = 500;
		double initialBalance = 800.0;
		
		Account acc = AccountFactory.createAccount(initialBalance);
		
		// Act
		acc.withdraw(amount);
		
		// Assertions
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		// Arrange		
		double amount = 801.0;
		double initialBalance = 800.0;
		
		Account acc = AccountFactory.createAccount(initialBalance);

		
		// Assertions
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Act
			acc.withdraw(amount);
		});
	}

}