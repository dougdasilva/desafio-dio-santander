package BancoSantander.Contas;

import java.time.LocalDateTime;

import BancoSantander.Bank;
import BancoSantander.Cliente.Client;
import Exceptions.SaldoNegativoException;

public class BronzeAccount extends Account {

	private double overdraft;
	private final double tax = 0.002;

	public BronzeAccount() {
	}

	public BronzeAccount(Bank bank, Client client, double balance) {
		super(bank, client, balance);
		this.overdraft = 1000.0;
	}

	public double getOverdraft() {
		return overdraft;
	}
	
	public void withdrawTransfer(double amount) {
		balance -= amount;
	}
	
	@Override
	public void overdraftWithdrawal(double amount) {
			this.overdraft -= amount;
	}

	@Override
	public void withdraw(double amount) {
		if (amount > balance) {
			throw new SaldoNegativoException("Saldo indisponível");
		} else {
			balance -= amount + (amount * tax);
		}
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	@Override
	public void transfer(double amount, Account accountDestin) {
		this.withdrawTransfer(amount);
		accountDestin.deposit(amount);
	}

	@Override
	public void bankStatement() {
		System.out.println(" ========== EXTRATO BANCARIO ==========");
		System.out.println("DATA: " + LocalDateTime.now());
		System.out.println(String.format("Banco: " + super.getBank()));
		System.out.println(String.format("Cliente: " + super.getClient()));
		System.out.println(String.format("Conta: %d", super.getAccountNumber()));
		System.out.println(String.format("Saldo: %.2f", super.getBalance()));
		System.out.println(String.format("Cheque especial: %.2f", getOverdraft()));
		System.out.println(String.format("Cartao de credito: " + super.getCreditCard()));
	}
}
