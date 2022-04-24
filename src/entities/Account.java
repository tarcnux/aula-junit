package entities;

public class Account {
	
	public static double DEPOSIT_FEE_PERCENTAGE = 0.02;
	
	private Long id;
	private Double balance;
	
	public Account() {};
	
	public Account(Long id, Double balance) {
		this.id = id;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}
	
	/**
	 * Deposita uma quantia e aumenta o saldo
	 * REGRA DE NEGÓCIO
	 * Para cada depósito, o banco desconta uma taxa percentual
	 *
	 * @param amount
	 */
	public void deposit(double amount) {		
		if (amount > 0) {
			amount -= amount * DEPOSIT_FEE_PERCENTAGE;
			balance += amount;
		}
	}
	
	/**
	 * Saca uma quantia e diminui o saldo
	 * REGRA DE NEGÓCIO
	 * Se a quantia a ser sacada for maior que o saldo atual
	 * lança uma exceção
	 * 
	 * @param amount
	 */
	public void withdraw(double amount) {
		if(amount > balance) {
			//Se q auntia é maior que o saldo, lança uma exceção
			throw new IllegalArgumentException();
		}
		balance -= amount;
	}
	
	/**
	 * Saca todo o saldo, zerando a conta
	 * @return valor Total sacado
	 */
	public double fullWithdraw() {
		double aux = balance;
		balance = 0.0;
		return aux;
	}


}
