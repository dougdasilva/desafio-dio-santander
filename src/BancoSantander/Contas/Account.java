package BancoSantander.Contas;

import BancoSantander.Bank;
import BancoSantander.CreditCard;
import BancoSantander.Cliente.Client;

public abstract class Account implements IAccount {

	protected Bank bank;
	protected Client client;
	protected Long accountNumber;
	protected double balance;
	protected CreditCard creditCard = new CreditCard();
	
	protected static Long count = 1L;
	
	public Account() {}
	
	public Account(Bank bank, Client client, double balance) {
		super();
		this.bank = bank;
		this.client = client;
		this.accountNumber = count;
		count++;
		this.balance = balance;

	}

	public Bank getBank() {
		return bank;
	}

	public Client getClient() {
		return client;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
}